package com.bhavik.services.covid19.impl.controller;

import com.bhavik.services.covid19.api.controller.ICovid19DataController;
import com.bhavik.services.covid19.api.model.Covid19AnalyticsResponse;
import com.bhavik.services.covid19.api.model.Covid19CreateRequest;
import com.bhavik.services.covid19.api.model.Covid19DailyResponse;
import com.bhavik.services.covid19.api.model.getdata.request.Covid19DataRequest;
import com.bhavik.services.covid19.api.model.getdata.response.Covid19DataResponse;
import com.bhavik.services.covid19.api.service.ICovid19DataService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class Covid19DataController implements ICovid19DataController {

	Logger logger = LoggerFactory.getLogger(Covid19DataController.class);

	@Autowired
	ICovid19DataService covid19DataService;

	@Override
	public List<Covid19DailyResponse> getAllCovid19Data() {
		return covid19DataService.getAllCovid19Data();
	}

	@Override
	public ResponseEntity<String> createCovid19Data(List<Covid19CreateRequest> requestData) {
		covid19DataService.createCovid19Data(requestData);
		return ResponseEntity.ok().build();
	}

	@Override
	public Covid19AnalyticsResponse getCovid19AnalyticsByDate(String date, String state) {
		logger.debug("Retrieving covid analytics data for {}", date);
		return covid19DataService.getCovid19Analytics(date, StringUtils.upperCase(state));
	}

	@Override
	public Covid19DataResponse getCovid19AnalyticsData(@RequestBody Covid19DataRequest dataRequest) {
		logger.debug("Retrieving Covid 19 Analytics Data");
		return covid19DataService.getCovid19AnalyticsData(dataRequest);
	}
}
