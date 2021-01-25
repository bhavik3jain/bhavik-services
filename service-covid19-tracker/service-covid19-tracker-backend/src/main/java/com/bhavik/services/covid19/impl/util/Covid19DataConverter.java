package com.bhavik.services.covid19.impl.util;

import com.bhavik.services.covid19.api.model.Covid19AnalyticsResponse;
import com.bhavik.services.covid19.api.model.Covid19DataRequest;
import com.bhavik.services.covid19.api.model.Covid19DataResponse;
import com.bhavik.services.covid19.api.model.Covid19DataEntity;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Covid19DataConverter {

    private Covid19DataConverter() {
        //Adding default constructor
    }

    public static Covid19DataResponse convertFromEntity(Covid19DataEntity entity) {
        return new Covid19DataResponse(
                LocalDate.now(),
                entity.getState(),
                entity.getPositiveIncrease(),
                entity.getDeathIncrease(),
                entity.getHospitalizedIncrease()
        );

    }

    public static Covid19DataEntity convertToEntity(Covid19DataRequest from) {
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

    public static String dateConverter(String dbDate) {
        SimpleDateFormat fromUser = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat myFormat = new SimpleDateFormat("MMMM dd yyyy");

        try {
            return myFormat.format(fromUser.parse(dbDate));
        } catch (Exception e) {
            return null;
        }
    }

    public static Covid19AnalyticsResponse createCovid19AnalyticsResponse(Object[] data) {
        Covid19AnalyticsResponse response = new Covid19AnalyticsResponse();

        response.setDate(data[0] != null ? dateConverter(String.valueOf(data[0])) : null);
        response.setPositiveIncrease(data[1] != null ? Integer.valueOf(String.valueOf(data[1])) : null);
        response.setHospitalizedIncrease(data[2] != null ? Integer.valueOf(String.valueOf(data[2])) : null);
        response.setDeathIncrease(data[3] != null ? Integer.valueOf(String.valueOf(data[3])) : null);

        return response;
    }
}
