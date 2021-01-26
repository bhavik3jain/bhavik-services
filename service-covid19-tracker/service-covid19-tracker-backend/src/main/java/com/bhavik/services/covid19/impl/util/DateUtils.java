package com.bhavik.services.covid19.impl.util;

import com.bhavik.services.covid19.api.model.getdata.request.Covid19DataDateRange;
import com.bhavik.services.covid19.api.model.getdata.request.Covid19DateRangeType;
import com.bhavik.services.covid19.api.provider.dateprovider.IDateResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class DateUtils {

    @Autowired
    private List<IDateResolver> dateResolvers;

    final Map<Covid19DateRangeType, IDateResolver> dateResolverMap = new HashMap<>();

    @PostConstruct
    public void init() {
        dateResolvers.forEach(resolver ->
                dateResolverMap.putIfAbsent(resolver.getDateRangeType(), resolver));
    }


    public List<LocalDate> getAllDatesInRange(LocalDate startDate, LocalDate endDate) {
        long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        return IntStream.iterate(0, i -> i + 1)
                .limit(numOfDaysBetween)
                .mapToObj(startDate::plusDays)
                .collect(Collectors.toList());
    }

    public String dateConverter(String dbDate) {
        SimpleDateFormat fromUser = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat myFormat = new SimpleDateFormat("MMMM dd yyyy");

        try {
            return myFormat.format(fromUser.parse(dbDate));
        } catch (Exception e) {
            return null;
        }
    }

    public String dateConverter(LocalDate dbDate) {
        SimpleDateFormat fromUser = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            return fromUser.format(myFormat.parse(dbDate.toString()));
        } catch (Exception e) {
            return null;
        }
    }

    public LocalDate dateComparisonConverter(String convertedDate) {
        SimpleDateFormat fromUser = new SimpleDateFormat("MMMM dd yyyy");
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            return LocalDate.parse(myFormat.format(fromUser.parse(convertedDate)));
        } catch (Exception e) {
            return null;
        }
    }

    public List<String> resolveDateRange(Covid19DataDateRange dateRange) {
        List<LocalDate> range;
        if(dateRange.getPeriod() != null) {
            range = dateResolverMap.get(dateRange.getPeriod()).resolveDateRange();
        } else {
            range = getAllDatesInRange(dateRange.getStartDate(), dateRange.getEndDate());
        }
        return range.stream().map(this::dateConverter).collect(Collectors.toList());
    }

}
