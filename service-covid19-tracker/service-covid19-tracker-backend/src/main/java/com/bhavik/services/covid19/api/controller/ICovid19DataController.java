package com.bhavik.services.covid19.api.controller;

import com.bhavik.services.covid19.api.model.Covid19AnalyticsResponse;
import com.bhavik.services.covid19.api.model.Covid19CreateRequest;
import com.bhavik.services.covid19.api.model.Covid19DailyResponse;
import com.bhavik.services.covid19.api.model.getdata.request.Covid19DataRequest;
import com.bhavik.services.covid19.api.model.getdata.response.Covid19DataResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface ICovid19DataController {

    @GetMapping(path = "/")
    ResponseEntity<String> getHealthCheck();

    @GetMapping(path = "/analytics")
    List<Covid19DailyResponse> getAllCovid19Data();

    @PostMapping(path = "/data/multi_create")
    ResponseEntity<String> createCovid19Data(@RequestBody List<Covid19CreateRequest> requestData);

    @GetMapping(path = "/analytics/read_analytics")
    Covid19AnalyticsResponse getCovid19AnalyticsByDate(
            @RequestParam(value = "date", required = false) String date,
            @RequestParam(value = "state", required = false) String state);

    @PostMapping(path = "/analytics/multi_read")
    Covid19DataResponse getCovid19AnalyticsData(@RequestBody Covid19DataRequest dataRequest);

}
