package com.project_service.project_service.repository;

import com.project_service.project_service.entity.ProjectInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectInfo,String> {
}
