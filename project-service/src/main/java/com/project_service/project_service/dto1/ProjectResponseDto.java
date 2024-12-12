package com.project_service.project_service.dto1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectResponseDto {
    private Long id;
    private String projectCode;
    private String projectName;
    private String description;
    private List<CollaboratorsDto> collaborators;
}
