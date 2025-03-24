package com.project_service.project_service.service;


import com.project_service.project_service.dto.EmployeeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "EMPLOYEE-SERVICE")
public interface EmployeeClient {

    @GetMapping("api/employee/{employeeId}")
    EmployeeDto getEmployeeById(@PathVariable("id") Long id);
}
