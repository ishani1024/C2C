package com.c2c.backend_java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.c2c.backend_java.model.LearningResource;

public interface LearningResourceRepository extends JpaRepository<LearningResource, Long> {

    List<LearningResource> findBySkillId(Long skillId);

    List<LearningResource> findByProvider(String provider);

    List<LearningResource> findByResourceType(String resourceType);
}
