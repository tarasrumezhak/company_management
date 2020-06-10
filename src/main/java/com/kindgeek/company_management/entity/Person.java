package com.kindgeek.company_management.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long personId;

    private String firstName;
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    private Position position;

    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;

    public long getId() {
        return personId;
    }

    public void setId(long id) {
        this.personId = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @JsonBackReference(value = "department-ref")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

//    public HashMap<String, String> getDepartmentInfo() {
//        HashMap<String, String> department = new HashMap<>();
//        department.put(this.department.toString(), "/api/department/" + this.department.getDepartmentId());
//        return department;
//    }


    @JsonBackReference(value = "position-ref")
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

//    public HashMap<String, String> getPositionInfo() {
//        HashMap<String, String> position = new HashMap<>();
//        position.put(this.position.toString(), "/api/position/" + this.position.getPositionId());
//        return position;
//    }


    @JsonBackReference(value = "project-ref")
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

//    public HashMap<String, String> getProjectInfo() {
//        HashMap<String, String> project = new HashMap<>();
//        project.put(this.project.toString(), "/api/project/" + this.project.getProjectId());
//        return project;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Person))
            return false;
        Person person = (Person) o;
        return Objects.equals(this.personId, person.personId) && Objects.equals(this.firstName, person.firstName)
                && Objects.equals(this.lastName, person.lastName) && Objects.equals(this.position, person.position)
                && Objects.equals(this.department, person.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.personId, this.firstName, this.lastName, this.position, this.department);
    }

}
