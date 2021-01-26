package com.bhavik.services.covid19.impl.provider.dateprovider;

import com.bhavik.services.covid19.api.model.getdata.request.Covid19DateRangeType;
import com.bhavik.services.covid19.api.provider.dateprovider.IDateResolver;
import com.bhavik.services.covid19.impl.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class LastThirtyDaysDateResolver implements IDateResolver {

    @Autowired
    private DateUtils dateUtils;

    @Override
    public Covid19DateRangeType getDateRangeType() {
        return Covid19DateRangeType.LAST_30_DAYS;
    }

    @Override
    public List<LocalDate> resolveDateRange() {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(30L);

        return dateUtils.getAllDatesInRange(startDate, endDate);
    }
}
