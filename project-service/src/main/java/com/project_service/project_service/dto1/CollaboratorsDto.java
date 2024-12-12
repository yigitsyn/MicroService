package com.project_service.project_service.dto1;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollaboratorsDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String role;
}
