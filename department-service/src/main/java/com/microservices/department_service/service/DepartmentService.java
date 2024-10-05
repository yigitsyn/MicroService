package com.microservices.department_service.service;

import com.microservices.department_service.dto.DepartmentDto;
import com.microservices.department_service.dto.DtoConverter;

import com.microservices.department_service.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DtoConverter dtoConverter;


    public DepartmentService(DepartmentRepository departmentRepository, DtoConverter dtoConverter) {
        this.departmentRepository = departmentRepository;
        this.dtoConverter = dtoConverter;
    }

    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        return dtoConverter.convertDepartmentDepartmentToDepartmentDto(departmentRepository.save(dtoConverter.convertDepartmentDtoToDepartment(departmentDto)));
    }

    public DepartmentDto getDepartment(String departmentCode) {
        return dtoConverter.convertDepartmentDepartmentToDepartmentDto(departmentRepository.findByDepartmentCode(departmentCode));
    }

}
