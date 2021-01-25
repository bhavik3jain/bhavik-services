package com.bhavik.services.covid19;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BhavikServicesCovid19Tracker {

	public static void main(String[] args) {
		SpringApplication.run(BhavikServicesCovid19Tracker.class, args);
	}

}
