package br.com.victorhugolgr.ead.course.repository;

import br.com.victorhugolgr.ead.course.models.ModuleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ModuleRepository extends JpaRepository<ModuleModel, UUID> {

    @Query(value="SELECT * FROM TB_MODULES WHERE course_course_id = :courseId", nativeQuery = true)
    List<ModuleModel> findAllModulesIntoCourse(@Param("courseId") UUID courseId);
}
