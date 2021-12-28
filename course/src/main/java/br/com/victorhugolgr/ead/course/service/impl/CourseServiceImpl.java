package br.com.victorhugolgr.ead.course.service.impl;

import br.com.victorhugolgr.ead.course.models.CourseModel;
import br.com.victorhugolgr.ead.course.models.LessonModel;
import br.com.victorhugolgr.ead.course.models.ModuleModel;
import br.com.victorhugolgr.ead.course.repository.CourseRepository;
import br.com.victorhugolgr.ead.course.repository.LessonRepository;
import br.com.victorhugolgr.ead.course.repository.ModuleRepository;
import br.com.victorhugolgr.ead.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final ModuleRepository moduleRepository;
    private final LessonRepository lessonRepository;

    @Transactional
    @Override
    public void delete(CourseModel courseModel) {
        List<ModuleModel> moduleModelList = moduleRepository.findAllModulesIntoCourse(courseModel.getCourseId());
        if(!moduleModelList.isEmpty()) {
            for (ModuleModel module: moduleModelList) {
                List<LessonModel> lessonModelList = lessonRepository.findAllLessonsIntoModule(module.getModuleId());
                if(!lessonModelList.isEmpty()) {
                    lessonRepository.deleteAll(lessonModelList);
                }
            }
            moduleRepository.deleteAll(moduleModelList);
        }
        courseRepository.delete(courseModel);
    }
}
