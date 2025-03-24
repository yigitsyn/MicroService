package com.project_service.project_service.controller;

import com.project_service.project_service.dto.ProjectInfoDto;
import com.project_service.project_service.entity.ProjectInfo;
import com.project_service.project_service.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/project/")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/addProjectwithCollaborators")
    ResponseEntity<?> addProjectInfo(@RequestBody ProjectInfoDto projectInfoDto) {
        if(projectInfoDto.getProjectName().isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(projectService.createProject(projectInfoDto), HttpStatus.CREATED);
    }



}
