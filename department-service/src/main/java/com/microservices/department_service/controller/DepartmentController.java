package com.microservices.department_service.controller;

import com.microservices.department_service.dto.DepartmentDto;
import com.microservices.department_service.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("api/department/")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
        departmentDto.setId(UUID.randomUUID().toString());
        return new ResponseEntity<>(departmentService.createDepartment(departmentDto), HttpStatus.CREATED);

    }
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("department-code") String  departmentCode) {
        return  ResponseEntity.ok(departmentService.getDepartment(departmentCode));
    }
}
