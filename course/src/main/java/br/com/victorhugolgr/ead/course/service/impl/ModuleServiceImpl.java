package br.com.victorhugolgr.ead.course.service.impl;

import br.com.victorhugolgr.ead.course.repository.ModuleRepository;
import br.com.victorhugolgr.ead.course.service.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModuleServiceImpl implements ModuleService {
    private final ModuleRepository moduleRepository;
}
