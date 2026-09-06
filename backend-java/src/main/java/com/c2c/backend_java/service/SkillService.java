package com.c2c.backend_java.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.c2c.backend_java.exception.ResourceNotFoundException;
import com.c2c.backend_java.model.Skill;
import com.c2c.backend_java.repository.SkillRepository;

@Service
public class SkillService {

    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public Skill createSkill(Skill skill) {
        if (skillRepository.findByName(skill.getName()).isPresent()) {
            throw new RuntimeException("Skill already exists");
        }

        return skillRepository.save(skill);
    }

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    public Skill getSkillById(Long id) {
        return skillRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skill not found"));
    }

    public Skill getSkillByName(String name) {
        return skillRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Skill not found"));
    }

    public Skill updateSkill(Long id, Skill updatedSkill) {
        Skill existingSkill = getSkillById(id);

        existingSkill.setName(updatedSkill.getName());
        existingSkill.setCategory(updatedSkill.getCategory());
        existingSkill.setDescription(updatedSkill.getDescription());

        return skillRepository.save(existingSkill);
    }

    public void deleteSkill(Long id) {
        if (!skillRepository.existsById(id)) {
            throw new ResourceNotFoundException("Skill not found");
        }

        skillRepository.deleteById(id);
    }
}