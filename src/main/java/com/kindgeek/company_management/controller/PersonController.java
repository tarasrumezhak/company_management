package com.kindgeek.company_management.controller;

import com.kindgeek.company_management.entity.Department;
import com.kindgeek.company_management.entity.Person;
import com.kindgeek.company_management.entity.Position;
import com.kindgeek.company_management.entity.Project;
import com.kindgeek.company_management.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path="/api/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody
    Person addNewPerson (@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @GetMapping
    public @ResponseBody Iterable<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping(path="{id}")
    public @ResponseBody Person getPersonById(@PathVariable("id") Long id) {
        return personService.getPersonById(id).orElse(null);
    }

    @PutMapping(path = "{id}/set_project_with_param")
    public @ResponseBody Person setProjectWithRequestParam(@PathVariable("id") Long id, @RequestParam Long position_id) {
        return personService.setProjectWithRequestParam(id, position_id);
    }

    @PutMapping(path = "{id}/set_project")
    public @ResponseBody Person setProject(@PathVariable("id") Long id, @RequestBody Project project) {
        return personService.setProject(id, project);
    }

    @PutMapping(path = "{id}/set_position_with_param")
    public @ResponseBody Person setPositionWithRequestParam(@PathVariable("id") Long id, @RequestParam Long position_id) {
        return personService.setPositionWithRequestParam(id, position_id);
    }

    @PutMapping(path = "{id}/set_position")
    public @ResponseBody Person setPosition(@PathVariable("id") Long id, @RequestBody Position position) {
        return personService.setPosition(id, position);
    }

    @PutMapping(path = "{id}/set_department_with_param")
    public @ResponseBody Person setDepartmentWithRequestParam(@PathVariable("id") Long id, @RequestParam Long department_id) {
        return personService.setDepartmentWithRequestParam(id, department_id);
    }

    @PutMapping(path = "{id}/set_department")
    public @ResponseBody Person setDepartment(@PathVariable("id") Long id, @RequestBody Department department) {
        return personService.setDepartment(id, department);
    }

    @DeleteMapping(path = "{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public Person updatePerson(@PathVariable("id") Long id, @RequestBody Person newPerson) {
        return personService.updatePerson(id, newPerson);
    }

}


