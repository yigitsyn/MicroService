package com.microservices.department_service.dto;

import com.microservices.department_service.entity.Department;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DtoConverter {

    public static Department convertDepartmentDtoToDepartment(DepartmentDto departmentDto) {
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
        return department;
    }
    public static DepartmentDto convertDepartmentDepartmentToDepartmentDto(Department department) {
        DepartmentDto departmentDto = new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
        return departmentDto;
    }
}
