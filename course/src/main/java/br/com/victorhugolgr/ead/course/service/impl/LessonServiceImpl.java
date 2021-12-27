package br.com.victorhugolgr.ead.course.service.impl;

import br.com.victorhugolgr.ead.course.repository.LessonRepository;
import br.com.victorhugolgr.ead.course.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;
}
