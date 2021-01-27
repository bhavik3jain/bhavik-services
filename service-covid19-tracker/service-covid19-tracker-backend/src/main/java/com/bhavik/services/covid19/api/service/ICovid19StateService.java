package com.bhavik.services.covid19.api.service;

import com.bhavik.services.covid19.api.model.Covid19State;

import java.util.List;

public interface ICovid19StateService {

    List<Covid19State> getAllCovid19States();

    void createCovid19States(List<Covid19State> states);
}
