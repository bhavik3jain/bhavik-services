package com.bhavik.services.covid19.api.model;

public class Covid19CreateRequest {

    private String date;
    private String dataQualityGrade;
    private Integer death;
    private Integer deathConfirmed;
    private Integer deathIncrease;
    private Integer deathProbable;
    private String fips;
    private Integer hospitalizedCumulative;
    private Integer hospitalizedCurrently;
    private Integer hospitalizedIncrease;
    private Integer inIcuCumulative;
    private Integer inIcuCurrently;
    private Integer negative;
    private Integer negativeTestsAntibody;
    private Integer negativeTestsPeopleAntibody;
    private Integer negativeTestsViral;
    private Integer onVentilatorCumulative;
    private Integer onVentilatorCurrently;
    private Integer pending;
    private Integer positive;
    private Integer positiveCasesViral;
    private Integer positiveIncrease;
    private Integer positiveTestsAntibody;
    private Integer positiveTestsAntigen;
    private Integer positiveTestsPeopleAntibody;
    private Integer positiveTestsPeopleAntigen;
    private Integer positiveTestsViral;
    private Integer probableCases;
    private Integer recovered;
    private String state;
    private Integer totalTestEncountersViral;
    private Integer totalTestResults;
    private Integer totalTestResultsIncrease;
    private Integer totalTestResultsSource;
    private Integer totalTestsAntibody;
    private Integer totalTestsAntigen;
    private Integer totalTestsPeopleAntibody;
    private Integer totalTestsPeopleAntigen;
    private Integer totalTestsPeopleViral;
    private Integer totalTestsViral;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDataQualityGrade() {
        return dataQualityGrade;
    }

    public void setDataQualityGrade(String dataQualityGrade) {
        this.dataQualityGrade = dataQualityGrade;
    }

    public Integer getDeath() {
        return death;
    }

    public void setDeath(Integer death) {
        this.death = death;
    }

    public Integer getDeathConfirmed() {
        return deathConfirmed;
    }

    public void setDeathConfirmed(Integer deathConfirmed) {
        this.deathConfirmed = deathConfirmed;
    }

    public Integer getDeathIncrease() {
        return deathIncrease;
    }

    public void setDeathIncrease(Integer deathIncrease) {
        this.deathIncrease = deathIncrease;
    }

    public Integer getDeathProbable() {
        return deathProbable;
    }

    public void setDeathProbable(Integer deathProbable) {
        this.deathProbable = deathProbable;
    }

    public String getFips() {
        return fips;
    }

    public void setFips(String fips) {
        this.fips = fips;
    }

    public Integer getHospitalizedCumulative() {
        return hospitalizedCumulative;
    }

    public void setHospitalizedCumulative(Integer hospitalizedCumulative) {
        this.hospitalizedCumulative = hospitalizedCumulative;
    }

    public Integer getHospitalizedCurrently() {
        return hospitalizedCurrently;
    }

    public void setHospitalizedCurrently(Integer hospitalizedCurrently) {
        this.hospitalizedCurrently = hospitalizedCurrently;
    }

    public Integer getHospitalizedIncrease() {
        return hospitalizedIncrease;
    }

    public void setHospitalizedIncrease(Integer hospitalizedIncrease) {
        this.hospitalizedIncrease = hospitalizedIncrease;
    }

    public Integer getInIcuCumulative() {
        return inIcuCumulative;
    }

    public void setInIcuCumulative(Integer inIcuCumulative) {
        this.inIcuCumulative = inIcuCumulative;
    }

    public Integer getInIcuCurrently() {
        return inIcuCurrently;
    }

    public void setInIcuCurrently(Integer inIcuCurrently) {
        this.inIcuCurrently = inIcuCurrently;
    }

    public Integer getNegative() {
        return negative;
    }

    public void setNegative(Integer negative) {
        this.negative = negative;
    }

    public Integer getNegativeTestsAntibody() {
        return negativeTestsAntibody;
    }

    public void setNegativeTestsAntibody(Integer negativeTestsAntibody) {
        this.negativeTestsAntibody = negativeTestsAntibody;
    }

    public Integer getNegativeTestsPeopleAntibody() {
        return negativeTestsPeopleAntibody;
    }

    public void setNegativeTestsPeopleAntibody(Integer negativeTestsPeopleAntibody) {
        this.negativeTestsPeopleAntibody = negativeTestsPeopleAntibody;
    }

    public Integer getNegativeTestsViral() {
        return negativeTestsViral;
    }

    public void setNegativeTestsViral(Integer negativeTestsViral) {
        this.negativeTestsViral = negativeTestsViral;
    }

    public Integer getOnVentilatorCumulative() {
        return onVentilatorCumulative;
    }

    public void setOnVentilatorCumulative(Integer onVentilatorCumulative) {
        this.onVentilatorCumulative = onVentilatorCumulative;
    }

    public Integer getOnVentilatorCurrently() {
        return onVentilatorCurrently;
    }

    public void setOnVentilatorCurrently(Integer onVentilatorCurrently) {
        this.onVentilatorCurrently = onVentilatorCurrently;
    }

    public Integer getPending() {
        return pending;
    }

    public void setPending(Integer pending) {
        this.pending = pending;
    }

    public Integer getPositive() {
        return positive;
    }

    public void setPositive(Integer positive) {
        this.positive = positive;
    }

    public Integer getPositiveCasesViral() {
        return positiveCasesViral;
    }

    public void setPositiveCasesViral(Integer positiveCasesViral) {
        this.positiveCasesViral = positiveCasesViral;
    }

    public Integer getPositiveIncrease() {
        return positiveIncrease;
    }

    public void setPositiveIncrease(Integer positiveIncrease) {
        this.positiveIncrease = positiveIncrease;
    }

    public Integer getPositiveTestsAntibody() {
        return positiveTestsAntibody;
    }

    public void setPositiveTestsAntibody(Integer positiveTestsAntibody) {
        this.positiveTestsAntibody = positiveTestsAntibody;
    }

    public Integer getPositiveTestsAntigen() {
        return positiveTestsAntigen;
    }

    public void setPositiveTestsAntigen(Integer positiveTestsAntigen) {
        this.positiveTestsAntigen = positiveTestsAntigen;
    }

    public Integer getPositiveTestsPeopleAntibody() {
        return positiveTestsPeopleAntibody;
    }

    public void setPositiveTestsPeopleAntibody(Integer positiveTestsPeopleAntibody) {
        this.positiveTestsPeopleAntibody = positiveTestsPeopleAntibody;
    }

    public Integer getPositiveTestsPeopleAntigen() {
        return positiveTestsPeopleAntigen;
    }

    public void setPositiveTestsPeopleAntigen(Integer positiveTestsPeopleAntigen) {
        this.positiveTestsPeopleAntigen = positiveTestsPeopleAntigen;
    }

    public Integer getPositiveTestsViral() {
        return positiveTestsViral;
    }

    public void setPositiveTestsViral(Integer positiveTestsViral) {
        this.positiveTestsViral = positiveTestsViral;
    }

    public Integer getProbableCases() {
        return probableCases;
    }

    public void setProbableCases(Integer probableCases) {
        this.probableCases = probableCases;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getTotalTestEncountersViral() {
        return totalTestEncountersViral;
    }

    public void setTotalTestEncountersViral(Integer totalTestEncountersViral) {
        this.totalTestEncountersViral = totalTestEncountersViral;
    }

    public Integer getTotalTestResults() {
        return totalTestResults;
    }

    public void setTotalTestResults(Integer totalTestResults) {
        this.totalTestResults = totalTestResults;
    }

    public Integer getTotalTestResultsIncrease() {
        return totalTestResultsIncrease;
    }

    public void setTotalTestResultsIncrease(Integer totalTestResultsIncrease) {
        this.totalTestResultsIncrease = totalTestResultsIncrease;
    }

    public Integer getTotalTestResultsSource() {
        return totalTestResultsSource;
    }

    public void setTotalTestResultsSource(Integer totalTestResultsSource) {
        this.totalTestResultsSource = totalTestResultsSource;
    }

    public Integer getTotalTestsAntibody() {
        return totalTestsAntibody;
    }

    public void setTotalTestsAntibody(Integer totalTestsAntibody) {
        this.totalTestsAntibody = totalTestsAntibody;
    }

    public Integer getTotalTestsAntigen() {
        return totalTestsAntigen;
    }

    public void setTotalTestsAntigen(Integer totalTestsAntigen) {
        this.totalTestsAntigen = totalTestsAntigen;
    }

    public Integer getTotalTestsPeopleAntibody() {
        return totalTestsPeopleAntibody;
    }

    public void setTotalTestsPeopleAntibody(Integer totalTestsPeopleAntibody) {
        this.totalTestsPeopleAntibody = totalTestsPeopleAntibody;
    }

    public Integer getTotalTestsPeopleAntigen() {
        return totalTestsPeopleAntigen;
    }

    public void setTotalTestsPeopleAntigen(Integer totalTestsPeopleAntigen) {
        this.totalTestsPeopleAntigen = totalTestsPeopleAntigen;
    }

    public Integer getTotalTestsPeopleViral() {
        return totalTestsPeopleViral;
    }

    public void setTotalTestsPeopleViral(Integer totalTestsPeopleViral) {
        this.totalTestsPeopleViral = totalTestsPeopleViral;
    }

    public Integer getTotalTestsViral() {
        return totalTestsViral;
    }

    public void setTotalTestsViral(Integer totalTestsViral) {
        this.totalTestsViral = totalTestsViral;
    }
}
