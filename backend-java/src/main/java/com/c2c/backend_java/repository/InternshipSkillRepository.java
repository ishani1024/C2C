package com.c2c.backend_java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.c2c.backend_java.model.InternshipSkill;

public interface InternshipSkillRepository extends JpaRepository<InternshipSkill, Long> {

    List<InternshipSkill> findByInternshipId(Long internshipId);

    List<InternshipSkill> findBySkillId(Long skillId);
}