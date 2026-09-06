package com.c2c.backend_java.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.c2c.backend_java.exception.ResourceNotFoundException;
import com.c2c.backend_java.model.Skill;
import com.c2c.backend_java.model.Student;
import com.c2c.backend_java.model.StudentSkill;
import com.c2c.backend_java.repository.SkillRepository;
import com.c2c.backend_java.repository.StudentRepository;
import com.c2c.backend_java.repository.StudentSkillRepository;

@Service
public class StudentSkillService {

    private final StudentSkillRepository studentSkillRepository;
    private final StudentRepository studentRepository;
    private final SkillRepository skillRepository;

    public StudentSkillService(StudentSkillRepository studentSkillRepository,
                               StudentRepository studentRepository,
                               SkillRepository skillRepository) {
        this.studentSkillRepository = studentSkillRepository;
        this.studentRepository = studentRepository;
        this.skillRepository = skillRepository;
    }

    public StudentSkill addSkillToStudent(Long studentId,
                                          Long skillId,
                                          String proficiencyLevel) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new ResourceNotFoundException("Skill not found"));

        if (studentSkillRepository.existsByStudentIdAndSkillId(studentId, skillId)) {
            throw new IllegalArgumentException("Student already has this skill");
        }

        StudentSkill studentSkill = new StudentSkill();

        studentSkill.setStudent(student);
        studentSkill.setSkill(skill);
        studentSkill.setProficiencyLevel(proficiencyLevel);

        return studentSkillRepository.save(studentSkill);
    }

    public List<StudentSkill> getAllStudentSkills() {
        return studentSkillRepository.findAll();
    }

    public List<StudentSkill> getSkillsByStudent(Long studentId) {
        return studentSkillRepository.findByStudentId(studentId);
    }

    public List<StudentSkill> getStudentsBySkill(Long skillId) {
        return studentSkillRepository.findBySkillId(skillId);
    }

    public StudentSkill getStudentSkillById(Long id) {
        return studentSkillRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student skill not found"));
    }

    public StudentSkill updateStudentSkill(Long id,
                                           String proficiencyLevel) {

        StudentSkill existingStudentSkill = getStudentSkillById(id);

        existingStudentSkill.setProficiencyLevel(proficiencyLevel);

        return studentSkillRepository.save(existingStudentSkill);
    }

    public void deleteStudentSkill(Long id) {
        if (!studentSkillRepository.existsById(id)) {
            throw new ResourceNotFoundException("Student skill not found");
        }

        studentSkillRepository.deleteById(id);
    }
}