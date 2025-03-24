package com.microservices.employee_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    private String id;
    private String name;
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    private String departmentCode;
    @Column(nullable = false)
    private int status;
}
