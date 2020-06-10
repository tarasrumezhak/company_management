package com.kindgeek.company_management.controller;

import com.kindgeek.company_management.entity.Department;
import com.kindgeek.company_management.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    Department addNewDepartment(@RequestBody Department department) {
        return departmentService.addDepartment(department);
    }

    @GetMapping
    public @ResponseBody Iterable<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping(path="{id}")
    public @ResponseBody Department getDepartmentById(@PathVariable("id") Long id) {
        return departmentService.getDepartmentById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
    }

    @PutMapping(path = "{id}")
    public Department updateDepartment(@PathVariable("id") Long id, @RequestBody Department newDepartment) {
        return departmentService.updateDepartment(id, newDepartment);
    }
}
