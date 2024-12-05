package com.microservices.department_service.service;

import com.microservices.department_service.dto.DepartmentDto;
import com.microservices.department_service.dto.DepartmentMapper;
import com.microservices.department_service.dto.DtoConverter;

import com.microservices.department_service.exception.DepartmentNameAlreadyExistException;
import com.microservices.department_service.exception.DepartmentNotFoundException;
import com.microservices.department_service.repository.DepartmentRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DtoConverter dtoConverter;
    private final DepartmentMapper departmentMapper;


    public DepartmentService(DepartmentRepository departmentRepository, DtoConverter dtoConverter, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.dtoConverter = dtoConverter;
        this.departmentMapper = departmentMapper;
    }

    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        if(departmentRepository.findByDepartmentName(departmentDto.getDepartmentName()).isPresent()) {
            throw new DepartmentNameAlreadyExistException(departmentDto.getDepartmentName(),"departmentName",departmentDto.getDepartmentName() );
        }else if(departmentRepository.findByDepartmentDescription(departmentDto.getDepartmentDescription()).isPresent())
            throw new DataIntegrityViolationException(departmentDto.getDepartmentDescription() +"is duplicated");
        return departmentMapper.departmentToDepartmentDto(departmentRepository.save(departmentMapper.departmentDtoToDepartment(departmentDto)));
    }


    public DepartmentDto getDepartment(String departmentCode) {
        return departmentMapper.departmentToDepartmentDto(departmentRepository.findByDepartmentCode(departmentCode).orElseThrow(()-> new DepartmentNotFoundException("Department is not found", "departmentCode", departmentCode)));
    }
}
