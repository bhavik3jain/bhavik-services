package com.bhavik.services.covid19.api.service;

import com.bhavik.services.covid19.api.model.Covid19AnalyticsResponse;
import com.bhavik.services.covid19.api.model.Covid19CreateRequest;
import com.bhavik.services.covid19.api.model.Covid19DailyResponse;
import com.bhavik.services.covid19.api.model.getdata.request.Covid19DataRequest;
import com.bhavik.services.covid19.api.model.getdata.response.Covid19DataResponse;

import java.util.List;

public interface ICovid19DataService {

    List<Covid19DailyResponse> getAllCovid19Data();

    void createCovid19Data(List<Covid19CreateRequest> requestData);

    Covid19AnalyticsResponse getCovid19Analytics(String date, String state);

    Covid19DataResponse getCovid19AnalyticsData(Covid19DataRequest dataRequest);
}
