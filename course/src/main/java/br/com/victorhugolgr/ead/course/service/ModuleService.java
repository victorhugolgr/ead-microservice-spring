package br.com.victorhugolgr.ead.course.service;

import br.com.victorhugolgr.ead.course.models.ModuleModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ModuleService {
    void delete(ModuleModel moduleModel);

    ModuleModel save(ModuleModel moduleModel);

    Optional<ModuleModel> findModuleIntoCourse(UUID courseId, UUID moduleId);

    List<ModuleModel> findAll();

    List<ModuleModel> findAllByCourse(UUID courseId);
}
