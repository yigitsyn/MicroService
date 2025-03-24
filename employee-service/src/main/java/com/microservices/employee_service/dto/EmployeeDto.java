package com.microservices.employee_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private String id;
    @NotEmpty(message = "User lastname should not be empyt.")
    private String name;
    @NotEmpty(message = "User lastname should not be empyt.")
    private String lastName;
    @NotEmpty(message = "User lastname should not be empyt.")
    @Email(message = "email address should be valid.")
    private String email;
    private String  departmentCode;
}
