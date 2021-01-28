package com.bhavik.services.covid19.api.model.getdata.request;

import com.bhavik.services.covid19.api.model.Covid19DataType;

import java.util.ArrayList;
import java.util.List;

public class Covid19DataSelect {

    private String state;

    private List<Covid19DataType> types = new ArrayList<>();

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Covid19DataType> getTypes() {
        return types;
    }

    public void setTypes(List<Covid19DataType> types) {
        this.types = types;
    }
}
