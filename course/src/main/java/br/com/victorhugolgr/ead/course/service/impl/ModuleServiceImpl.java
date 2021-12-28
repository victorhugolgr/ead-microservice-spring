package br.com.victorhugolgr.ead.course.service.impl;

import br.com.victorhugolgr.ead.course.models.LessonModel;
import br.com.victorhugolgr.ead.course.models.ModuleModel;
import br.com.victorhugolgr.ead.course.repository.LessonRepository;
import br.com.victorhugolgr.ead.course.repository.ModuleRepository;
import br.com.victorhugolgr.ead.course.service.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuleServiceImpl implements ModuleService {
    private final ModuleRepository moduleRepository;
    private final LessonRepository lessonRepository;

    @Transactional
    @Override
    public void delete(ModuleModel moduleModel) {
        List<LessonModel> lessonModelList = lessonRepository.findAllLessonsIntoModule(moduleModel.getModuleId());
        if(!lessonModelList.isEmpty()) {
            lessonRepository.deleteAll(lessonModelList);
        }
        moduleRepository.delete(moduleModel);
    }
}
