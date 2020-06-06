package com.kindgeek.company_management.repository;

import com.kindgeek.company_management.entity.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
}
