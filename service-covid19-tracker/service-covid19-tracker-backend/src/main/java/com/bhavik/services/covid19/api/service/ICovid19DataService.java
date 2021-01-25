package com.bhavik.services.covid19.api.service;

import com.bhavik.services.covid19.api.model.Covid19AnalyticsResponse;
import com.bhavik.services.covid19.api.model.Covid19DataRequest;
import com.bhavik.services.covid19.api.model.Covid19DataResponse;

import java.util.List;

public interface ICovid19DataService {

    List<Covid19DataResponse> getAllCovid19Data();

    void createCovid19Data(List<Covid19DataRequest> requestData);

    Covid19AnalyticsResponse getCovid19Analytics(String date);

}
