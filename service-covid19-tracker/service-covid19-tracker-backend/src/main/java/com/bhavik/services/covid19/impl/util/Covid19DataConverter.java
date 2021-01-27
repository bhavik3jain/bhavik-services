package com.bhavik.services.covid19.impl.util;

import com.bhavik.services.covid19.api.model.*;
import com.bhavik.services.covid19.api.model.entity.Covid19DataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Map;

@Component
public class Covid19DataConverter {

    @Autowired
    private DateUtils dateUtils;

    public Covid19DailyResponse convertFromEntity(Covid19DataEntity entity) {
        return new Covid19DailyResponse(
                LocalDate.now(),
                entity.getState(),
                entity.getPositiveIncrease(),
                entity.getDeathIncrease(),
                entity.getHospitalizedIncrease()
        );

    }

    public Covid19DataEntity convertToEntity(Covid19CreateRequest from) {
        Covid19DataEntity to = new Covid19DataEntity();
        to.setTotalTestsPeopleViral(from.getTotalTestsPeopleViral());
        to.setState(from.getState());
        to.setHospitalizedIncrease(from.getHospitalizedIncrease());
        to.setInIcuCumulative(from.getInIcuCumulative());
        to.setNegative(from.getNegative());
        to.setDeath(from.getDeath());
        to.setPositiveIncrease(from.getPositiveIncrease());
        to.setTotalTestsPeopleAntigen(from.getTotalTestsPeopleAntigen());
        to.setOnVentilatorCumulative(from.getOnVentilatorCumulative());
        to.setNegativeTestsPeopleAntibody(from.getNegativeTestsPeopleAntibody());
        to.setPositiveTestsAntigen(from.getPositiveTestsAntigen());
        to.setFips(from.getFips());
        to.setTotalTestResultsSource(from.getTotalTestResultsSource());
        to.setHospitalizedCumulative(from.getHospitalizedCumulative());
        to.setTotalTestsAntibody(from.getTotalTestsAntibody());
        to.setTotalTestResultsIncrease(from.getTotalTestResultsIncrease());
        to.setPositiveTestsAntibody(from.getPositiveTestsAntibody());
        to.setPositiveTestsPeopleAntibody(from.getPositiveTestsPeopleAntibody());
        to.setTotalTestResults(from.getTotalTestResults());
        to.setDeathConfirmed(from.getDeathConfirmed());
        to.setTotalTestsPeopleAntibody(from.getTotalTestsPeopleAntibody());
        to.setDate(from.getDate());
        to.setProbableCases(from.getProbableCases());
        to.setDeathIncrease(from.getDeathIncrease());
        to.setTotalTestsViral(from.getTotalTestsViral());
        to.setPositiveCasesViral(from.getPositiveCasesViral());
        to.setTotalTestsAntigen(from.getTotalTestsAntigen());
        to.setNegativeTestsAntibody(from.getNegativeTestsAntibody());
        to.setHospitalizedCurrently(from.getHospitalizedCurrently());
        to.setInIcuCurrently(from.getInIcuCurrently());
        to.setDataQualityGrade(from.getDataQualityGrade());
        to.setNegativeTestsViral(from.getNegativeTestsViral());
        to.setRecovered(from.getRecovered());
        to.setDeathProbable(from.getDeathProbable());
        to.setPositiveTestsPeopleAntigen(from.getPositiveTestsPeopleAntigen());
        to.setPositive(from.getPositive());
        to.setTotalTestEncountersViral(from.getTotalTestEncountersViral());
        to.setPending(from.getPending());
        to.setOnVentilatorCurrently(from.getOnVentilatorCurrently());
        to.setPositiveTestsViral(from.getPositiveTestsViral());

        return to;
    }

    public Covid19AnalyticsResponse createCovid19AnalyticsResponse(Map data) {
        Covid19AnalyticsResponse response = new Covid19AnalyticsResponse();

        response.setDate(data.get(Covid19DataType.DATE.getTypeName()) != null ? dateUtils.dateConverter(String.valueOf(data.get(Covid19DataType.DATE.getTypeName()))) : null);
        response.setPositiveIncrease(data.get(Covid19DataType.CASES.getTypeName()) != null ? Integer.valueOf(String.valueOf(data.get(Covid19DataType.CASES.getTypeName()))) : null);
        response.setHospitalizedIncrease(data.get(Covid19DataType.HOSPITALIZED.getTypeName()) != null ? Integer.valueOf(String.valueOf(data.get(Covid19DataType.HOSPITALIZED.getTypeName()))) : null);
        response.setDeathIncrease(data.get(Covid19DataType.DEATHS.getTypeName()) != null ? Integer.valueOf(String.valueOf(data.get(Covid19DataType.DEATHS.getTypeName()))) : null);

        return response;
    }
}
