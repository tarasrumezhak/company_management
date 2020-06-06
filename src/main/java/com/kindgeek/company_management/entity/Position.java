package com.kindgeek.company_management.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
//@Table(name = "positions")
public class Position {

    @Id
    @Column(name="position_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long positionId;


    @OneToMany(mappedBy = "position", fetch = FetchType.LAZY)
    private Set<Person> persons;

    private String technology;
    private String proficiency;

    public String getTechnology() {
        return technology;
    }

    public Position setTechnology(String technology) {
        this.technology = technology;
        return this;
    }

    public String getProficiency() {
        return proficiency;
    }

    public Position setProficiency(String proficiency) {
        this.proficiency = proficiency;
        return this;
    }

    @JsonManagedReference(value = "position-ref")
    public Set<Person> getPersons() {
        return persons;
    }

    public Position setPersons(Set<Person> persons) {
        this.persons = persons;
        return this;
    }

    public long getPositionId() {
        return positionId;
    }

    public Position setPositionId(long positionId) {
        this.positionId = positionId;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s %s developer", this.proficiency, this.technology);
    }

}
