package com.microservices.department_service.repository;

import com.microservices.department_service.dto.DepartmentDto;
import com.microservices.department_service.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, String> {

    Optional<Department> findByDepartmentCode(String departmentCode);

    Optional<Department> findByDepartmentName(String departmentName);

    Optional<Department> findByDepartmentDescription(String description);



}
