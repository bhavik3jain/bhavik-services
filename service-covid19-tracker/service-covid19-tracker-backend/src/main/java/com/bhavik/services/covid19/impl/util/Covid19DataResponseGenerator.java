package com.bhavik.services.covid19.impl.util;

import com.bhavik.services.covid19.api.model.Covid19DataType;
import com.bhavik.services.covid19.api.model.getdata.request.Covid19DataRequest;
import com.bhavik.services.covid19.api.model.getdata.response.Covid19DailyAggregate;
import com.bhavik.services.covid19.api.model.getdata.response.Covid19DataResponse;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Covid19DataResponseGenerator {

    private final Map<Covid19DataType, ResponseGenerator> dataFunctions = new HashMap<>();

    @Autowired
    private DateUtils dateUtils;

    @PostConstruct
    public void init() {
        ResponseGenerator addTotalCases = ((response, data) -> {
            Covid19DailyAggregate aggregate = new Covid19DailyAggregate();

            if(data.get(Covid19DataType.CASES.getTypeName()) != null) {
                Integer totalCases = Integer.valueOf(String.valueOf(data.get(Covid19DataType.CASES.getTypeName())));
                aggregate.setValue(totalCases);
            }
            if(data.get(Covid19DataType.DATE.getTypeName()) != null) {
                String date = dateUtils.dateConverter(String.valueOf(data.get(Covid19DataType.DATE.getTypeName())));
                aggregate.setDate(date);
            }

            response.getTotalCases().add(aggregate);
        });

        ResponseGenerator addTotalDeaths = ((response, data) -> {
            Covid19DailyAggregate aggregate = new Covid19DailyAggregate();

            if(data.get(Covid19DataType.DEATHS.getTypeName()) != null) {
                Integer totalCases = Integer.valueOf(String.valueOf(data.get(Covid19DataType.DEATHS.getTypeName())));
                aggregate.setValue(totalCases);
            }
            if(data.get(Covid19DataType.DATE.getTypeName()) != null) {
                String date = dateUtils.dateConverter(String.valueOf(data.get(Covid19DataType.DATE.getTypeName())));
                aggregate.setDate(date);
            }

            response.getTotalDeaths().add(aggregate);
        });

        ResponseGenerator addTotalHospitalizations = ((response, data) -> {
            Covid19DailyAggregate aggregate = new Covid19DailyAggregate();

            if(data.get(Covid19DataType.HOSPITALIZED.getTypeName()) != null) {
                Integer totalCases = Integer.valueOf(String.valueOf(data.get(Covid19DataType.HOSPITALIZED.getTypeName())));
                aggregate.setValue(totalCases);
            }
            if(data.get(Covid19DataType.DATE.getTypeName()) != null) {
                String date = dateUtils.dateConverter(String.valueOf(data.get(Covid19DataType.DATE.getTypeName())));
                aggregate.setDate(date);
            }

            response.getTotalHospitalizations().add(aggregate);
        });

        dataFunctions.putIfAbsent(Covid19DataType.CASES, addTotalCases);
        dataFunctions.putIfAbsent(Covid19DataType.DEATHS, addTotalDeaths);
        dataFunctions.putIfAbsent(Covid19DataType.HOSPITALIZED, addTotalHospitalizations);
    }

    @FunctionalInterface
    private interface ResponseGenerator {
        void addData(Covid19DataResponse response, Map data);
    }

    public Covid19DataResponse createCovid19DataResponse(Covid19DataRequest request, List<Map> data) {
        Covid19DataResponse dataResponse = new Covid19DataResponse();

        data.forEach(row -> {
            List<Covid19DataType> types;
            if(CollectionUtils.isEmpty(request.getSelect().getTypes())) {
                types = Covid19DataType.getAll();
            } else {
                types = request.getSelect().getTypes();
            }

            types.forEach(type -> dataFunctions.get(type).addData(dataResponse, row));
        });

        return dataResponse;
    }

}
