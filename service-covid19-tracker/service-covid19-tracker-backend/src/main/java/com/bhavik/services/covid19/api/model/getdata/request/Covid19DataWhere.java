package com.bhavik.services.covid19.api.model.getdata.request;

public class Covid19DataWhere {

    private Covid19DataDateRange dateRange;

    public Covid19DataDateRange getDateRange() {
        return dateRange;
    }

    public void setDateRange(Covid19DataDateRange dateRange) {
        this.dateRange = dateRange;
    }
}
