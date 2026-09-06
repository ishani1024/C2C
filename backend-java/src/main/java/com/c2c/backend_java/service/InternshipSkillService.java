package com.c2c.backend_java.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.c2c.backend_java.model.Internship;
import com.c2c.backend_java.model.InternshipSkill;
import com.c2c.backend_java.model.Skill;
import com.c2c.backend_java.repository.InternshipRepository;
import com.c2c.backend_java.repository.InternshipSkillRepository;
import com.c2c.backend_java.repository.SkillRepository;

@Service
public class InternshipSkillService {

    private final InternshipSkillRepository internshipSkillRepository;
    private final InternshipRepository internshipRepository;
    private final SkillRepository skillRepository;

    public InternshipSkillService(InternshipSkillRepository internshipSkillRepository,
                                  InternshipRepository internshipRepository,
                                  SkillRepository skillRepository) {
        this.internshipSkillRepository = internshipSkillRepository;
        this.internshipRepository = internshipRepository;
        this.skillRepository = skillRepository;
    }

    public InternshipSkill addSkillToInternship(Long internshipId,
                                                Long skillId,
                                                String requiredLevel) {

        Internship internship = internshipRepository.findById(internshipId)
                .orElseThrow(() -> new RuntimeException("Internship not found"));

        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new RuntimeException("Skill not found"));

        InternshipSkill internshipSkill = new InternshipSkill();

        internshipSkill.setInternship(internship);
        internshipSkill.setSkill(skill);
        internshipSkill.setRequiredLevel(requiredLevel);

        return internshipSkillRepository.save(internshipSkill);
    }

    public List<InternshipSkill> getAllInternshipSkills() {
        return internshipSkillRepository.findAll();
    }

    public List<InternshipSkill> getSkillsByInternship(Long internshipId) {
        return internshipSkillRepository.findByInternshipId(internshipId);
    }

    public List<InternshipSkill> getInternshipsBySkill(Long skillId) {
        return internshipSkillRepository.findBySkillId(skillId);
    }

    public InternshipSkill getInternshipSkillById(Long id) {
        return internshipSkillRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Internship skill not found"));
    }

    public InternshipSkill updateInternshipSkill(Long id,
                                                 String requiredLevel) {

        InternshipSkill existingInternshipSkill = getInternshipSkillById(id);

        existingInternshipSkill.setRequiredLevel(requiredLevel);

        return internshipSkillRepository.save(existingInternshipSkill);
    }

    public void deleteInternshipSkill(Long id) {
        if (!internshipSkillRepository.existsById(id)) {
            throw new RuntimeException("Internship skill not found");
        }

        internshipSkillRepository.deleteById(id);
    }
}