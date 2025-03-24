package com.project_service.project_service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectInfoDto {
    private String projectName;
    private String projectDescription;
    private List<Long> collaboratorsId;
    private LocalDate creationTime;
}
