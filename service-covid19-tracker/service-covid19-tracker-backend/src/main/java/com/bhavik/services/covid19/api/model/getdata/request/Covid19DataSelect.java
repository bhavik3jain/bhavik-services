package com.bhavik.services.covid19.api.model.getdata.request;

import com.bhavik.services.covid19.api.model.Covid19DataType;

import java.util.ArrayList;
import java.util.List;

public class Covid19DataSelect {

    List<Covid19DataType> types = new ArrayList<>();

    public List<Covid19DataType> getTypes() {
        return types;
    }

    public void setTypes(List<Covid19DataType> types) {
        this.types = types;
    }
}
