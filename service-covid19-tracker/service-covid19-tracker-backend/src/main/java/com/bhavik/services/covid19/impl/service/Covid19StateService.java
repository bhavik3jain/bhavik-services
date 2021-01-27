package com.bhavik.services.covid19.impl.service;

import com.bhavik.services.covid19.api.model.Covid19State;
import com.bhavik.services.covid19.api.model.entity.Covid19StatesEntity;
import com.bhavik.services.covid19.api.repository.Covid19StateRepository;
import com.bhavik.services.covid19.api.service.ICovid19StateService;
import com.bhavik.services.covid19.impl.util.Covid19StateConverter;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Covid19StateService implements ICovid19StateService {

    Logger logger = LoggerFactory.getLogger(Covid19StateService.class);

    @Autowired
    private Covid19StateRepository repository;

    @Override
    public List<Covid19State> getAllCovid19States() {
        List<Covid19StatesEntity> states = repository.findAll();
        return states.stream().map(Covid19StateConverter::convertToDto).collect(Collectors.toList());
    }

    @Override
    public void createCovid19States(List<Covid19State> states) {
        List<Covid19StatesEntity> entities = states
                .stream()
                .map(Covid19StateConverter::convertToEntity)
                .collect(Collectors.toList());

        List<Covid19StatesEntity> existingStates = repository.findAll();

        entities.removeAll(existingStates);

        if(!CollectionUtils.isEmpty(entities)) {
            logger.info("Adding the following states into the database: {}", entities);
            repository.saveAll(entities);
        } else {
            logger.info("No states left to add");
        }
    }
}
