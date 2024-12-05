package com.microservices.department_service.dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private String id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}
