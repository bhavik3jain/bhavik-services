package com.bhavik.services.covid19.api.repository;

import com.bhavik.services.covid19.api.model.Covid19DataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface Covid19DataRepository extends JpaRepository<Covid19DataEntity, Long> {

    @Query("select c from Covid19DataEntity c where c.state = :state")
    Collection<Covid19DataEntity> findAllCovidDataByState(@Param("state") String state);

    @Query(value =
            "select c.date, sum(c.positiveIncrease), sum(c.deathIncrease), sum(c.hospitalizedIncrease) from Covid19DataEntity c\n" +
            "where c.date = (select max(c.date) from Covid19DataEntity c)\n" +
            "group by c.date")
    List<Object[]> findCurrentCovidAnalytics();

    @Query(value =
            "select c.date, sum(c.positiveIncrease), sum(c.deathIncrease), sum(c.hospitalizedIncrease) from Covid19DataEntity c\n" +
                    "where c.date = :date\n" +
                    "group by c.date")
    List<Object[]> findCovidAnalyticsByDate(String date);
}