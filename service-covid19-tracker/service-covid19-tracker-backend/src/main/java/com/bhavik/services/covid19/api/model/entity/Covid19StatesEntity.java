package com.bhavik.services.covid19.api.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "COVID19_STATES")
public class Covid19StatesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "state")
    private String state;

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Covid19StatesEntity entity = (Covid19StatesEntity) o;
        return Objects.equals(state, entity.state) && Objects.equals(name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, state, name);
    }

    @Override
    public String toString() {
        return getState();
    }
}
