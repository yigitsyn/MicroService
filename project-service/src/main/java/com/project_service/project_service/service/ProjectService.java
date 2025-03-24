package com.project_service.project_service.service;

import com.project_service.project_service.dto.EmployeeDto;
import com.project_service.project_service.dto.ProjectInfoDto;
import com.project_service.project_service.entity.ProjectInfo;
import com.project_service.project_service.repository.ProjectRepository;
import feign.FeignException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;
    private final EmployeeClient employeeClient;

    public ProjectService(ProjectRepository projectRepository, ModelMapper modelMapper, EmployeeClient employeeClient) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;

        this.employeeClient = employeeClient;
    }

    public ProjectInfoDto createProject(ProjectInfoDto projectInfoDto) {
        projectInfoDto.setCreationTime(LocalDate.now());
        List<Long> validCollaborators = new ArrayList<>();
        if(projectInfoDto.getCollaboratorsId()!= null && !projectInfoDto.getCollaboratorsId().isEmpty()) {
            for(Long collaboratorId : projectInfoDto.getCollaboratorsId()) {
                try{
                    EmployeeDto employeeDto = employeeClient.getEmployeeById(collaboratorId);
                    if(employeeDto!=null){
                        validCollaborators.add(collaboratorId);
                    }
                }catch(FeignException e){}
            }
        }
        projectInfoDto.setCollaboratorsId(validCollaborators);

        return modelMapper.map(projectRepository.save(modelMapper.map(projectInfoDto,ProjectInfo.class)),ProjectInfoDto.class);

    }


}
