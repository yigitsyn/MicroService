package com.microservices.employee_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDto {

    EmployeeDto employeeDto;
    DepartmentDto departmentDto;
    ProjectDto projectDto;
}
