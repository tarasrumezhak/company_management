package com.kindgeek.company_management.service;

import com.kindgeek.company_management.entity.Department;
import com.kindgeek.company_management.entity.Person;
import com.kindgeek.company_management.entity.Position;
import com.kindgeek.company_management.entity.Project;
import com.kindgeek.company_management.repository.DepartmentRepository;
import com.kindgeek.company_management.repository.PersonRepository;
import com.kindgeek.company_management.repository.PositionRepository;
import com.kindgeek.company_management.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final ProjectRepository projectRepository;
    private final PositionRepository positionRepository;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public PersonService(PersonRepository personRepository, ProjectRepository projectRepository, PositionRepository positionRepository, DepartmentRepository departmentRepository) {
        this.personRepository = personRepository;
        this.projectRepository = projectRepository;
        this.positionRepository = positionRepository;
        this.departmentRepository = departmentRepository;
    }

    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    public Iterable<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }



    public Person setPositionWithRequestParam(Long person_id, Long position_id) {
        return personRepository.findById(person_id)
                .map(person -> {
                    person.setPosition(positionRepository.findById(position_id).orElse(null));
                    return personRepository.save(person);
                })
                .orElse(null);
    }

    public Person setPosition(Long person_id, Position position) {
        return personRepository.findById(person_id)
                .map(person -> {
                    person.setPosition(position);
                    return personRepository.save(person);
                })
                .orElse(null);
    }

    public Person setDepartmentWithRequestParam(Long person_id, Long department_id) {
        return personRepository.findById(person_id)
                .map(person -> {
                    person.setDepartment(departmentRepository.findById(department_id).orElse(null));
                    return personRepository.save(person);
                })
                .orElse(null);
    }

    public Person setDepartment(Long person_id, Department department) {
        return personRepository.findById(person_id)
            .map(person -> {
                person.setDepartment(department);
                return personRepository.save(person);
            })
            .orElse(null);
    }

    public Person setProjectWithRequestParam(Long person_id, Long project_id) {
        return personRepository.findById(person_id)
                .map(person -> {
                    person.setProject(projectRepository.findById(project_id).orElse(null));
                    return personRepository.save(person);
                })
                .orElse(null);
    }

    public Person setProject(Long person_id, Project project) {
        return personRepository.findById(person_id)
                .map(person -> {
                    person.setProject(project);
                    return personRepository.save(person);
                })
                .orElse(null);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    public Person updatePerson(Long id, Person newPerson) {
        return personRepository.findById(id)
                .map(person -> {
                    String firstName = newPerson.getFirstName();
                    String lastName = newPerson.getLastName();
                    Position position = newPerson.getPosition();
                    Department department = newPerson.getDepartment();
                    Project project = newPerson.getProject();
                    if (firstName != null) person.setFirstName(firstName);
                    if (lastName != null) person.setLastName(lastName);
                    if (position != null) person.setPosition(position);
                    if (department != null) person.setDepartment(department);
                    if (project != null) person.setProject(project);
                    return personRepository.save(person);
                })
                .orElseGet(() -> {
                    newPerson.setId(id);
                    return personRepository.save(newPerson);
                });
    }
}
