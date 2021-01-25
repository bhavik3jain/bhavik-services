package com.bhavik.services.covid19.api.controller;

import com.bhavik.services.covid19.api.model.Covid19AnalyticsResponse;
import com.bhavik.services.covid19.api.model.Covid19DataRequest;
import com.bhavik.services.covid19.api.model.Covid19DataResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface ICovid19DataController {

    @GetMapping(path = "/")
    List<Covid19DataResponse> getAllCovid19Data();

    @PostMapping(path = "/multi_create")
    ResponseEntity<String> createCovid19Data(@RequestBody List<Covid19DataRequest> requestData);

    @GetMapping(path = "/read_analytics")
    Covid19AnalyticsResponse getCovid19Analytics(@RequestParam(value = "date", required = false) String date);

}
