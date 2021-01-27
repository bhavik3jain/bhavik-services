package com.bhavik.services.covid19.api.repository;

import com.bhavik.services.covid19.api.model.entity.Covid19StatesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Covid19StateRepository extends JpaRepository<Covid19StatesEntity, Long> {

}
