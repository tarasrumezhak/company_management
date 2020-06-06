package com.kindgeek.company_management.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
//@Table(name = "departments")
public class Department {

    @Id
    @Column(name="department_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long departmentId;

    private String departmentName;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private Set<Person> persons;


    public String getDepartmentName() {
        return departmentName;
    }

    public Department setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
        return this;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public Department setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
        return this;
    }

    @JsonManagedReference(value = "department-ref")
    public Set<Person> getPersons() {
        return persons;
    }

    public Department setPersons(Set<Person> persons) {
        this.persons = persons;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s department", this.departmentName);
    }
}
