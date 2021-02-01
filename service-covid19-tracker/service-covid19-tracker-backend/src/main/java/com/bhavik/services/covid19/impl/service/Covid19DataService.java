package com.bhavik.services.covid19.impl.service;

import com.bhavik.services.covid19.api.model.Covid19AnalyticsResponse;
import com.bhavik.services.covid19.api.model.Covid19CreateRequest;
import com.bhavik.services.covid19.api.model.Covid19DailyResponse;
import com.bhavik.services.covid19.api.model.entity.Covid19DataEntity;
import com.bhavik.services.covid19.api.model.entity.Covid19StatesEntity;
import com.bhavik.services.covid19.api.model.getdata.request.Covid19DataRequest;
import com.bhavik.services.covid19.api.model.getdata.response.Covid19DataResponse;
import com.bhavik.services.covid19.api.repository.Covid19DataRepository;
import com.bhavik.services.covid19.api.repository.Covid19StateRepository;
import com.bhavik.services.covid19.api.service.ICovid19DataService;
import com.bhavik.services.covid19.impl.util.Covid19DataConverter;
import com.bhavik.services.covid19.impl.util.Covid19DataResponseGenerator;
import com.bhavik.services.covid19.impl.util.DateUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class Covid19DataService implements ICovid19DataService {

	Logger logger = LoggerFactory.getLogger(Covid19DataService.class);

	@Autowired
	private Covid19DataRepository covid19DataRepository;

	@Autowired
	private Covid19StateRepository covid19StateRepository;

	@Autowired
	private Covid19DataResponseGenerator generator;

	@Autowired
	private Covid19DataConverter dataConverter;

	@Autowired
	private DateUtils dateUtils;

	@Override
	public List<Covid19DailyResponse> getAllCovid19Data() {
		List<Covid19DataEntity> covid19DataEntities = covid19DataRepository.findAll();

		return covid19DataEntities.stream()
				.map(dataConverter::convertFromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void createCovid19Data(List<Covid19CreateRequest> requestData) {
		List<Covid19DataEntity> covid19DataEntities = requestData.stream()
				.map(dataConverter::convertToEntity)
				.collect(Collectors.toList());

		Collection<Covid19DataEntity> existingData = covid19DataRepository.findAllCovidDataByState(requestData.get(0).getState());
		logger.info("State: {} has {} records", requestData.get(0).getState(), existingData.size());

		List<String> existingKeys = existingData.stream().map(Covid19DataEntity::getDate).collect(Collectors.toList());
		covid19DataEntities.removeIf(addData -> existingKeys.contains(addData.getDate()));

		List<List<Covid19DataEntity>> mapReduce = ListUtils.partition(covid19DataEntities, 20);

		mapReduce.parallelStream().forEach(map -> {
			try {
				logger.info("Inserting {} rows for {}", map.size(), map.get(0).getState());
				covid19DataRepository.saveAll(map);
			} catch (Exception e) {
				logger.error("Error when saving covid data");
			}
		});
	}

	@Override
	public Covid19AnalyticsResponse getCovid19Analytics(String date, String state) {
		logger.debug("Reading covid analytics from database");
		List<Map> data;

		List<String> statesToRetrieve = getStates(state);

		if(StringUtils.isEmpty(date)) {
			logger.debug("Date was not passed in, will read current analytics");
			data = covid19DataRepository.findCurrentCovidAnalytics(statesToRetrieve);
		} else {
			logger.debug("Retrieving analytics for {} date", date);
			data = covid19DataRepository.findCovidAnalyticsByDates(Collections.singletonList(date), statesToRetrieve);
		}
		if(CollectionUtils.isEmpty(data)) {
			logger.info("No data exists for the following date: {}", date);
			return null;
		}

		return dataConverter.createCovid19AnalyticsResponse(data.get(0));
	}

	@Override
	public Covid19DataResponse getCovid19AnalyticsData(Covid19DataRequest dataRequest) {
		List<String> dates = dateUtils.resolveDateRange(dataRequest.getWhere().getDateRange());
		List<String> statesToRetrieve = getStates(StringUtils.upperCase(dataRequest.getSelect().getState()));

		if(!CollectionUtils.isEmpty(dates)) {
			logger.info("Retrieving analytics for the following dates {} and following states {}", dates, statesToRetrieve);
			List<Map> data = covid19DataRepository.findCovidAnalyticsByDates(dates, statesToRetrieve);

			Covid19DataResponse response = generator.createCovid19DataResponse(dataRequest, data);

			response.getTotalCases().sort((c1, c2) -> {
				LocalDate ld1 = dateUtils.dateComparisonConverter(c1.getDate());
				LocalDate ld2 = dateUtils.dateComparisonConverter(c2.getDate());

				return ld1.compareTo(ld2);
			});

			response.getTotalDeaths().sort((c1, c2) -> {
				LocalDate ld1 = dateUtils.dateComparisonConverter(c1.getDate());
				LocalDate ld2 = dateUtils.dateComparisonConverter(c2.getDate());

				return ld1.compareTo(ld2);
			});

			response.getCurrentHospitalizations().sort((c1, c2) -> {
				LocalDate ld1 = dateUtils.dateComparisonConverter(c1.getDate());
				LocalDate ld2 = dateUtils.dateComparisonConverter(c2.getDate());

				return ld1.compareTo(ld2);
			});

			return response;
		}
		return null;
	}

	private List<String> getStates(String state) {
		List<String> statesToRetrieve;

		if(StringUtils.isEmpty(state)) {
			List<Covid19StatesEntity> statesEntities = covid19StateRepository.findAll();
			statesToRetrieve = statesEntities.stream().map(Covid19StatesEntity::getState).collect(Collectors.toList());
		} else {
			statesToRetrieve = Collections.singletonList(state);
		}

		return statesToRetrieve;
	}

}
