package com.c2c.backend_java.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.c2c.backend_java.exception.ResourceNotFoundException;
import com.c2c.backend_java.model.LearningResource;
import com.c2c.backend_java.model.Skill;
import com.c2c.backend_java.repository.LearningResourceRepository;
import com.c2c.backend_java.repository.SkillRepository;

@Service
public class LearningResourceService {

    private final LearningResourceRepository learningResourceRepository;
    private final SkillRepository skillRepository;

    public LearningResourceService(LearningResourceRepository learningResourceRepository,
                                   SkillRepository skillRepository) {
        this.learningResourceRepository = learningResourceRepository;
        this.skillRepository = skillRepository;
    }

    public LearningResource createResource(Long skillId,
                                           LearningResource resource) {

        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new ResourceNotFoundException("Skill not found"));

        resource.setSkill(skill);

        return learningResourceRepository.save(resource);
    }

    public List<LearningResource> getAllResources() {
        return learningResourceRepository.findAll();
    }

    public LearningResource getResourceById(Long id) {
        return learningResourceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Learning resource not found"));
    }

    public List<LearningResource> getResourcesBySkill(Long skillId) {
        return learningResourceRepository.findBySkillId(skillId);
    }

    public List<LearningResource> getResourcesByProvider(String provider) {
        return learningResourceRepository.findByProvider(provider);
    }

    public List<LearningResource> getResourcesByType(String resourceType) {
        return learningResourceRepository.findByResourceType(resourceType);
    }

    public LearningResource updateResource(Long id,
                                           LearningResource updatedResource) {

        LearningResource existingResource = getResourceById(id);

        existingResource.setTitle(updatedResource.getTitle());
        existingResource.setDescription(updatedResource.getDescription());
        existingResource.setResourceType(updatedResource.getResourceType());
        existingResource.setUrl(updatedResource.getUrl());
        existingResource.setProvider(updatedResource.getProvider());

        return learningResourceRepository.save(existingResource);
    }

    public void deleteResource(Long id) {
        if (!learningResourceRepository.existsById(id)) {
            throw new ResourceNotFoundException("Learning resource not found");
        }

        learningResourceRepository.deleteById(id);
    }
}