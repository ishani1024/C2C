package com.c2c.backend_java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.c2c.backend_java.model.StudentSkill;

public interface StudentSkillRepository extends JpaRepository<StudentSkill, Long> {

    List<StudentSkill> findByStudentId(Long studentId);

    List<StudentSkill> findBySkillId(Long skillId);

    boolean existsByStudentIdAndSkillId(Long studentId, Long skillId);
}