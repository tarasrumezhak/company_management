package com.kindgeek.company_management.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

@Entity
//@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long personId;

    private String firstName;
    private String lastName;


    @ManyToOne(fetch = FetchType.LAZY)
    private Position position;

//    private String positionName;


    //    @JsonManagedReference
    @ManyToMany(cascade=CascadeType.ALL)
//    @JoinColumn(name = "project_id", referencedColumnName = "id")
    @JoinTable(name = "person_project",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
    private Set<Project> projects;


    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;

    @JsonBackReference(value = "department-ref")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

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

    @JsonBackReference(value = "position-ref")
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public HashMap<String, String> getPositionInfo() {
        HashMap<String, String> position = new HashMap<>();
        position.put(this.position.toString(), "/api/position/" + this.position.getPositionId());
        return position;
    }

    public HashMap<String, String> getDepartmentInfo() {
        HashMap<String, String> department = new HashMap<>();
        department.put(this.department.toString(), "/api/department/" + this.department.getDepartmentId());
        return department;
    }


//    public HashMap<String, Link> getProjects() {
//        HashMap<String, Link> projects = new HashMap<>();
//        for (Project p: this.projects) {
//            Link link = new Link("localhost:8080/api/project/" + p.getProject_id());
//            projects.put(p.getProjectName(), link);
//        }
//        return projects;
//    }

//    @JsonBackReference(value = "project-ref")
    @JsonIgnore
    public Set<Project> getProjects() {
        return projects;
    }

    public void addProject(Project newProject) {
        this.projects.add(newProject);
    }

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
