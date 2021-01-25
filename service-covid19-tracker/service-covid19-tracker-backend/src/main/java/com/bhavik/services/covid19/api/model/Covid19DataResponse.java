package com.bhavik.services.covid19.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Covid19DataResponse {

	private LocalDate date;
	private String state;
	private Integer positiveIncrease;
	private Integer deathIncrease;
	private Integer hospitalizedIncrease;

	public Covid19DataResponse() {
		//Empty Constructor
	}

	public Covid19DataResponse(LocalDate date, String state, Integer positiveIncrease, Integer deathIncrease, Integer hospitalizedIncrease) {
		this.date = date;
		this.state = state;
		this.positiveIncrease = positiveIncrease;
		this.deathIncrease = deathIncrease;
		this.hospitalizedIncrease = hospitalizedIncrease;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	public Integer getHospitalizedIncrease() {
		return hospitalizedIncrease;
	}

	public void setHospitalizedIncrease(Integer hospitalizedIncrease) {
		this.hospitalizedIncrease = hospitalizedIncrease;
	}
}
