package com.kindgeek.company_management.controller;

import com.kindgeek.company_management.entity.Project;
import com.kindgeek.company_management.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/project")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping(path = "/add")
    public @ResponseBody Project addNewProject(@RequestBody Project project) {
        return projectService.addProject(project);
    }

    @GetMapping
    public @ResponseBody Iterable<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping(path="{id}")
    public @ResponseBody
    Project getProjectById(@PathVariable("id") Long id) {
        return projectService.getProjectById(id).orElse(null);
    }
}
