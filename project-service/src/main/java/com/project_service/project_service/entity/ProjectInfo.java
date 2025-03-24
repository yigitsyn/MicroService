package com.project_service.project_service.entity;


import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.List;


@Entity(name = "projectInfo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectInfo {

    @Id
    @UuidGenerator
    private String id;

    private String projectName;

    private String projectDescription;

    @ElementCollection
    private List<Long> collaboratorsId;

    private LocalDate creationTime;

}
