package com.bhavik.services.covid19.api.model.getdata.response;

import java.util.ArrayList;
import java.util.List;

public class Covid19DataResponse {

    private List<Covid19DailyAggregate> totalCases = new ArrayList<>();
    private List<Covid19DailyAggregate> totalDeaths = new ArrayList<>();
    private List<Covid19DailyAggregate> currentHospitalizations = new ArrayList<>();

    public List<Covid19DailyAggregate> getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(List<Covid19DailyAggregate> totalCases) {
        this.totalCases = totalCases;
    }

    public List<Covid19DailyAggregate> getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(List<Covid19DailyAggregate> totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public List<Covid19DailyAggregate> getCurrentHospitalizations() {
        return currentHospitalizations;
    }

    public void setCurrentHospitalizations(List<Covid19DailyAggregate> currentHospitalizations) {
        this.currentHospitalizations = currentHospitalizations;
    }
}
