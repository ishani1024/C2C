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

import com.c2c.backend_java.model.InternshipSkill;
import com.c2c.backend_java.service.InternshipSkillService;

@RestController
@RequestMapping("/api/internship-skills")
@CrossOrigin(origins = "*")
public class InternshipSkillController {

    private final InternshipSkillService internshipSkillService;

    public InternshipSkillController(
            InternshipSkillService internshipSkillService) {

        this.internshipSkillService = internshipSkillService;
    }

    @PostMapping("/internship/{internshipId}/skill/{skillId}")
    public ResponseEntity<InternshipSkill> addSkillToInternship(
            @PathVariable Long internshipId,
            @PathVariable Long skillId,
            @RequestParam String requiredLevel) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(internshipSkillService.addSkillToInternship(
                        internshipId,
                        skillId,
                        requiredLevel
                ));
    }

    @GetMapping
    public ResponseEntity<List<InternshipSkill>> getAllInternshipSkills() {

        return ResponseEntity.ok(
                internshipSkillService.getAllInternshipSkills()
        );
    }

    @GetMapping("/internship/{internshipId}")
    public ResponseEntity<List<InternshipSkill>> getSkillsByInternship(
            @PathVariable Long internshipId) {

        return ResponseEntity.ok(
                internshipSkillService.getSkillsByInternship(
                        internshipId
                )
        );
    }

    @GetMapping("/skill/{skillId}")
    public ResponseEntity<List<InternshipSkill>> getInternshipsBySkill(
            @PathVariable Long skillId) {

        return ResponseEntity.ok(
                internshipSkillService.getInternshipsBySkill(skillId)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<InternshipSkill> getInternshipSkillById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                internshipSkillService.getInternshipSkillById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<InternshipSkill> updateInternshipSkill(
            @PathVariable Long id,
            @RequestParam String requiredLevel) {

        return ResponseEntity.ok(
                internshipSkillService.updateInternshipSkill(
                        id,
                        requiredLevel
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInternshipSkill(
            @PathVariable Long id) {

        internshipSkillService.deleteInternshipSkill(id);
        return ResponseEntity.noContent().build();
    }
}