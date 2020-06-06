package com.kindgeek.company_management.service;


import com.kindgeek.company_management.entity.Department;
import com.kindgeek.company_management.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Iterable<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    public Department updateDepartment(Long id, Department newDepartment) {
        return departmentRepository.findById(id)
                .map(department -> {
                    department.setDepartmentName(newDepartment.getDepartmentName());
                    return departmentRepository.save(department);
                })
                .orElseGet(() -> {
                    newDepartment.setDepartmentId(id);
                    return departmentRepository.save(newDepartment);
                });
    }
}
