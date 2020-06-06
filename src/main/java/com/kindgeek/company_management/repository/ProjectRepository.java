package com.kindgeek.company_management.repository;

import com.kindgeek.company_management.entity.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}
