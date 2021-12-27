package br.com.victorhugolgr.ead.course.repository;

import br.com.victorhugolgr.ead.course.models.ModuleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ModuleRepository extends JpaRepository<ModuleModel, UUID> {
}
