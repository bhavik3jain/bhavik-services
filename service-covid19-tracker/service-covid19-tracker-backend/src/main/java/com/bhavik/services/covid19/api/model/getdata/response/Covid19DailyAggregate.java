package com.bhavik.services.covid19.api.model.getdata.response;

public class Covid19DailyAggregate {

    private String date;
    private Integer value;

    public Covid19DailyAggregate() {
    }

    public Covid19DailyAggregate(String date, Integer value) {
        this.date = date;
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
