package com.kindgeek.company_management.repository;


import com.kindgeek.company_management.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
