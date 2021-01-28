package com.bhavik.services.covid19.api.model;

public class Covid19State {

    private String state;
    private String name;

    public Covid19State() {
    }

    public Covid19State(String state, String name) {
        this.state = state;
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
