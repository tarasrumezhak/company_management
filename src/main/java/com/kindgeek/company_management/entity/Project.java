package com.kindgeek.company_management.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
//@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long project_id;

    private String projectName;

//    @JsonBackReference
//    @JsonIgnore
    @ManyToMany(mappedBy = "projects")
    private Set<Person> persons;

    public String getProjectName() {
        return projectName;
    }

    public Project setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

//    @JsonManagedReference(value = "project-ref")
    public Set<Person> getPersons() {
        return persons;
    }

    public Project setPersons(Set<Person> persons) {
        this.persons = persons;
        return this;
    }

    public long getProject_id() {
        return project_id;
    }
}
