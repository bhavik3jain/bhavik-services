package com.bhavik.services.covid19.api.model;

public class Covid19State {

    private String state;

    public Covid19State() {
    }

    public Covid19State(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
