package com.bhavik.services.covid19.impl.controller;

import com.bhavik.services.covid19.api.controller.ICovid19HealthCheckController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Covid19HealthCheckController implements ICovid19HealthCheckController {

	@Override
	public ResponseEntity<String> getHealthCheck() {
		return ResponseEntity.ok().build();
	}
}
