package com.bhavik.services.covid19.api.model.getdata.request;

import java.time.LocalDate;

public class Covid19DataDateRange {

    private LocalDate startDate;
    private LocalDate endDate;
    private Covid19DateRangeType period;

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Covid19DateRangeType getPeriod() {
        return period;
    }

    public void setPeriod(Covid19DateRangeType period) {
        this.period = period;
    }
}
