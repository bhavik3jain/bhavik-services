package com.bhavik.services.covid19.impl.util;

import com.bhavik.services.covid19.api.model.Covid19State;
import com.bhavik.services.covid19.api.model.entity.Covid19StatesEntity;

public class Covid19StateConverter {

    public static Covid19StatesEntity convertToEntity(Covid19State state) {
        Covid19StatesEntity entity = new Covid19StatesEntity();
        entity.setState(state.getState());
        return entity;
    }

    public static Covid19State convertToDto(Covid19StatesEntity entity) {
        return new Covid19State(entity.getState());
    }

}
