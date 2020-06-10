package com.kindgeek.company_management.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Project {

    @Id
    @Column(name="project_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long projectId;

    private String projectName;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private Set<Person> persons = new HashSet<>();

    public String getProjectName() {
        return projectName;
    }

    public Project setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    @JsonManagedReference(value = "project-ref")
    public Set<Person> getPersons() {
        return persons;
    }

    public Project setPersons(Set<Person> persons) {
        this.persons = persons;
        return this;
    }

    public long getProjectId() {
        return projectId;
    }

    public Project setProjectId(long projectId) {
        this.projectId = projectId;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s project", this.projectName);
    }
}
