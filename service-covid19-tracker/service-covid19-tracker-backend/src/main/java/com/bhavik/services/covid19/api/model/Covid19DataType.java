package com.bhavik.services.covid19.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;
import java.util.List;

public enum Covid19DataType {

    DATE("date"),
    CASES("cases"),
    DEATHS("deaths"),
    HOSPITALIZED("hospitalized");

    private final String typeName;

    Covid19DataType(String typeName) {
        this.typeName = typeName;
    }

    @JsonCreator
    public static Covid19DataType fromValue(String value) {
        return Covid19DataType.valueOf(value);
    }

    public String getTypeName() {
        return typeName;
    }

    public static List<Covid19DataType> getAll() {
        List<Covid19DataType> all = Arrays.asList(Covid19DataType.values());
        all.remove(DATE);

        return all;
    }
}
