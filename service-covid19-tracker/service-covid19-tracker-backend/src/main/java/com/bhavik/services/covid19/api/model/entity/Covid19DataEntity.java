package com.bhavik.services.covid19.api.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "COVID19_STATE_DATA")
public class Covid19DataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private String date;

    @Column(name = "data_quality_grade")
    private String dataQualityGrade;

    @Column(name = "death")
    private Integer death;

    @Column(name = "death_confirmed")
    private Integer deathConfirmed;

    @Column(name = "death_increase")
    private Integer deathIncrease;

    @Column(name = "death_probable")
    private Integer deathProbable;

    @Column(name = "fips")
    private String fips;

    @Column(name = "hospitalized_cumulative")
    private Integer hospitalizedCumulative;

    @Column(name = "hospitalized_currently")
    private Integer hospitalizedCurrently;

    @Column(name = "hospitalized_increase")
    private Integer hospitalizedIncrease;

    @Column(name = "in_icu_cumulative")
    private Integer inIcuCumulative;

    @Column(name = "in_icu_currently")
    private Integer inIcuCurrently;

    @Column(name = "negative")
    private Integer negative;

    @Column(name = "negative_tests_antibody")
    private Integer negativeTestsAntibody;

    @Column(name = "negative_tests_people_antibody")
    private Integer negativeTestsPeopleAntibody;

    @Column(name = "negative_tests_viral")
    private Integer negativeTestsViral;

    @Column(name = "on_ventilator_cumulative")
    private Integer onVentilatorCumulative;

    @Column(name = "on_ventilator_currently")
    private Integer onVentilatorCurrently;

    @Column(name = "pending")
    private Integer pending;

    @Column(name = "positive")
    private Integer positive;

    @Column(name = "positive_cases_viral")
    private Integer positiveCasesViral;

    @Column(name = "positive_increase")
    private Integer positiveIncrease;

    @Column(name = "positive_tests_antibody")
    private Integer positiveTestsAntibody;

    @Column(name = "positive_tests_antigen")
    private Integer positiveTestsAntigen;

    @Column(name = "positive_tests_people_antibody")
    private Integer positiveTestsPeopleAntibody;

    @Column(name = "positive_tests_people_antigen")
    private Integer positiveTestsPeopleAntigen;

    @Column(name = "positive_tests_viral")
    private Integer positiveTestsViral;

    @Column(name = "probable_cases")
    private Integer probableCases;

    @Column(name = "recovered")
    private Integer recovered;

    @Column(name = "state")
    private String state;

    @Column(name = "total_test_encounters_viral")
    private Integer totalTestEncountersViral;

    @Column(name = "total_test_results")
    private Integer totalTestResults;

    @Column(name = "total_test_results_increase")
    private Integer totalTestResultsIncrease;

    @Column(name = "total_test_results_source")
    private Integer totalTestResultsSource;

    @Column(name = "total_tests_antibody")
    private Integer totalTestsAntibody;

    @Column(name = "total_tests_antigen")
    private Integer totalTestsAntigen;

    @Column(name = "total_tests_people_antibody")
    private Integer totalTestsPeopleAntibody;

    @Column(name = "total_tests_people_antigen")
    private Integer totalTestsPeopleAntigen;

    @Column(name = "total_tests_people_viral")
    private Integer totalTestsPeopleViral;

    @Column(name = "total_tests_viral")
    private Integer totalTestsViral;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
