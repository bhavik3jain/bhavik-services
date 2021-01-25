package com.bhavik.services.covid19.impl.service;

import com.bhavik.services.covid19.api.model.Covid19AnalyticsResponse;
import com.bhavik.services.covid19.api.model.Covid19DataRequest;
import com.bhavik.services.covid19.api.model.Covid19DataResponse;
import com.bhavik.services.covid19.api.model.Covid19DataEntity;
import com.bhavik.services.covid19.api.repository.Covid19DataRepository;
import com.bhavik.services.covid19.api.service.ICovid19DataService;
import com.bhavik.services.covid19.impl.util.Covid19DataConverter;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Covid19DataService implements ICovid19DataService {

	Logger logger = LoggerFactory.getLogger(Covid19DataService.class);

	@Autowired
	private Covid19DataRepository covid19DataRepository;

	@Override
	public List<Covid19DataResponse> getAllCovid19Data() {
		List<Covid19DataEntity> covid19DataEntities = covid19DataRepository.findAll();

		return covid19DataEntities.stream()
				.map(Covid19DataConverter::convertFromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void createCovid19Data(List<Covid19DataRequest> requestData) {
		List<Covid19DataEntity> covid19DataEntities = requestData.stream()
				.map(Covid19DataConverter::convertToEntity)
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
	public Covid19AnalyticsResponse getCovid19Analytics(String date) {
		logger.debug("Reading covid analytics from database");
		List<Object[]> data;
		if(StringUtils.isEmpty(date)) {
			logger.debug("Date was not passed in, will read current analytics");
			data = covid19DataRepository.findCurrentCovidAnalytics();
		} else {
			logger.debug("Retrieving analytics for {} date", date);
			data = covid19DataRepository.findCovidAnalyticsByDate(date);
		}
		if(CollectionUtils.isEmpty(data)) {
			logger.info("No data exists for the following date: {}", date);
			return null;
		}

		return Covid19DataConverter.createCovid19AnalyticsResponse(data.get(0));
	}

}
