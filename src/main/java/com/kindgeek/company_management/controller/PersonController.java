package com.kindgeek.company_management.controller;

import com.kindgeek.company_management.entity.Person;
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

//    @PutMapping(path = "{id}/add_project")
//    public @ResponseBody Person addProjectToPerson(@PathVariable("id") Long id, @RequestParam Long project_id) {
//        return personService.addProjectToPerson(id, project_id);
//    }

//    @PutMapping(path = "{id}/set_position")
//    public @ResponseBody Person setPosition(@PathVariable("id") Long id, @RequestParam Long position_id) {
//        return personService.setPosition(id, position_id);
//    }

//    @PutMapping(path = "{id}/set_department")
//    public @ResponseBody Person setDepartment(@PathVariable("id") Long id, @RequestParam Long department_id) {
//        return personService.setDepartment(id, department_id);
//    }

    @DeleteMapping(path = "{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public Person updatePerson(@PathVariable("id") Long id, @RequestBody Person newPerson) {
        return personService.updatePerson(id, newPerson);
    }

}


