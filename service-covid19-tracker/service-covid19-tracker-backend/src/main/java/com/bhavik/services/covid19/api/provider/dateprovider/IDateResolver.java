package com.bhavik.services.covid19.api.provider.dateprovider;

import com.bhavik.services.covid19.api.model.getdata.request.Covid19DateRangeType;

import java.time.LocalDate;
import java.util.List;

public interface IDateResolver {

    Covid19DateRangeType getDateRangeType();

    List<LocalDate> resolveDateRange();

}
