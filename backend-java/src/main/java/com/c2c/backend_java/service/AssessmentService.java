package com.c2c.backend_java.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.c2c.backend_java.model.Assessment;
import com.c2c.backend_java.model.Skill;
import com.c2c.backend_java.model.Student;
import com.c2c.backend_java.repository.AssessmentRepository;
import com.c2c.backend_java.repository.SkillRepository;
import com.c2c.backend_java.repository.StudentRepository;

@Service
public class AssessmentService {

    private final AssessmentRepository assessmentRepository;
    private final StudentRepository studentRepository;
    private final SkillRepository skillRepository;

    public AssessmentService(AssessmentRepository assessmentRepository,
                             StudentRepository studentRepository,
                             SkillRepository skillRepository) {
        this.assessmentRepository = assessmentRepository;
        this.studentRepository = studentRepository;
        this.skillRepository = skillRepository;
    }

    public Assessment createAssessment(Long studentId,
                                       Long skillId,
                                       Double score) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new RuntimeException("Skill not found"));

        Assessment assessment = new Assessment();

        assessment.setStudent(student);
        assessment.setSkill(skill);
        assessment.setScore(score);
        assessment.setAssessmentDate(LocalDateTime.now());

        return assessmentRepository.save(assessment);
    }

    public List<Assessment> getAllAssessments() {
        return assessmentRepository.findAll();
    }

    public List<Assessment> getAssessmentsByStudent(Long studentId) {
        return assessmentRepository.findByStudentId(studentId);
    }

    public List<Assessment> getAssessmentsBySkill(Long skillId) {
        return assessmentRepository.findBySkillId(skillId);
    }

    public Assessment getAssessmentById(Long id) {
        return assessmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assessment not found"));
    }

    public Assessment updateAssessment(Long id,
                                       Double score) {

        Assessment assessment = getAssessmentById(id);

        assessment.setScore(score);

        return assessmentRepository.save(assessment);
    }

    public void deleteAssessment(Long id) {
        if (!assessmentRepository.existsById(id)) {
            throw new RuntimeException("Assessment not found");
        }

        assessmentRepository.deleteById(id);
    }
}