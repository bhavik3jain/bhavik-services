package com.bhavik.services.covid19.api.model.getdata.request;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Covid19DateRangeType {

    LAST_7_DAYS,
    LAST_30_DAYS;

    @JsonCreator
    public static Covid19DateRangeType fromValue(String value) {
        return Covid19DateRangeType.valueOf(value);
    }


}
