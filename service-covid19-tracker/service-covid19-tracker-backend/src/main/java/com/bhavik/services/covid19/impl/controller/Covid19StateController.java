package com.bhavik.services.covid19.impl.controller;

import com.bhavik.services.covid19.api.controller.ICovid19StatesController;
import com.bhavik.services.covid19.api.model.Covid19State;
import com.bhavik.services.covid19.api.service.ICovid19DataService;
import com.bhavik.services.covid19.api.service.ICovid19StateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Covid19StateController implements ICovid19StatesController {

	Logger logger = LoggerFactory.getLogger(Covid19StateController.class);

	@Autowired
	ICovid19StateService covid19StateService;

	@Override
	public List<Covid19State> getAllCovid19States() {
		return covid19StateService.getAllCovid19States();
	}

	@Override
	public ResponseEntity<String> createCovid19States(List<Covid19State> states) {
		covid19StateService.createCovid19States(states);
		return ResponseEntity.ok().build();
	}
}
