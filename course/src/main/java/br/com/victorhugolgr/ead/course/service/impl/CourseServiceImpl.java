package br.com.victorhugolgr.ead.course.service.impl;

import br.com.victorhugolgr.ead.course.repository.CourseRepository;
import br.com.victorhugolgr.ead.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
}
