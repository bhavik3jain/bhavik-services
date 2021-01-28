package com.bhavik.services.covid19.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Covid19AnalyticsResponse {

	private String date;
	private Integer positiveIncrease;
	private Integer deathIncrease;
	private Integer hospitalizedCurrently;

	public Covid19AnalyticsResponse() {
		//Empty Constructor
	}

	public Covid19AnalyticsResponse(String date, String state, Integer positiveIncrease, Integer deathIncrease, Integer hospitalizedIncrease) {
		this.date = date;
		this.positiveIncrease = positiveIncrease;
		this.deathIncrease = deathIncrease;
		this.hospitalizedCurrently = hospitalizedIncrease;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getPositiveIncrease() {
		return positiveIncrease;
	}

	public void setPositiveIncrease(Integer positiveIncrease) {
		this.positiveIncrease = positiveIncrease;
	}

	public Integer getDeathIncrease() {
		return deathIncrease;
	}

	public void setDeathIncrease(Integer deathIncrease) {
		this.deathIncrease = deathIncrease;
	}

	public Integer getHospitalizedCurrently() {
		return hospitalizedCurrently;
	}

	public void setHospitalizedCurrently(Integer hospitalizedCurrently) {
		this.hospitalizedCurrently = hospitalizedCurrently;
	}
}
