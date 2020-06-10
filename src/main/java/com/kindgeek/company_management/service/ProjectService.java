package com.kindgeek.company_management.service;

import com.kindgeek.company_management.entity.Project;
import com.kindgeek.company_management.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    public Iterable<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    public Project updateProject(Long id, Project newProject) {
        return projectRepository.findById(id)
                .map(project -> {
                    String projectName = newProject.getProjectName();
                    if (projectName != null) project.setProjectName(projectName);
                    return projectRepository.save(project);
                })
                .orElseGet(() -> {
                    newProject.setProjectId(id);
                    return projectRepository.save(newProject);
                });
    }
}
