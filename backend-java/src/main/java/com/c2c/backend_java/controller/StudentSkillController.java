package com.c2c.backend_java.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.c2c.backend_java.model.StudentSkill;
import com.c2c.backend_java.service.StudentSkillService;

@RestController
@RequestMapping("/api/student-skills")
@CrossOrigin(origins = "*")
public class StudentSkillController {

    private final StudentSkillService studentSkillService;

    public StudentSkillController(StudentSkillService studentSkillService) {
        this.studentSkillService = studentSkillService;
    }

    @PostMapping("/student/{studentId}/skill/{skillId}")
    public ResponseEntity<StudentSkill> addSkillToStudent(
            @PathVariable Long studentId,
            @PathVariable Long skillId,
            @RequestParam String proficiencyLevel) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentSkillService.addSkillToStudent(
                        studentId,
                        skillId,
                        proficiencyLevel
                ));
    }

    @GetMapping
    public ResponseEntity<List<StudentSkill>> getAllStudentSkills() {

        return ResponseEntity.ok(
                studentSkillService.getAllStudentSkills()
        );
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<StudentSkill>> getSkillsByStudent(
            @PathVariable Long studentId) {

        return ResponseEntity.ok(
                studentSkillService.getSkillsByStudent(studentId)
        );
    }

    @GetMapping("/skill/{skillId}")
    public ResponseEntity<List<StudentSkill>> getStudentsBySkill(
            @PathVariable Long skillId) {

        return ResponseEntity.ok(
                studentSkillService.getStudentsBySkill(skillId)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentSkill> getStudentSkillById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                studentSkillService.getStudentSkillById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentSkill> updateStudentSkill(
            @PathVariable Long id,
            @RequestParam String proficiencyLevel) {

        return ResponseEntity.ok(
                studentSkillService.updateStudentSkill(
                        id,
                        proficiencyLevel
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentSkill(
            @PathVariable Long id) {

        studentSkillService.deleteStudentSkill(id);
        return ResponseEntity.noContent().build();
    }
}