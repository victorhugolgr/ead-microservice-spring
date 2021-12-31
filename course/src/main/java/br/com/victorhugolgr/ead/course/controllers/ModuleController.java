package br.com.victorhugolgr.ead.course.controllers;

import br.com.victorhugolgr.ead.course.dtos.CourseDto;
import br.com.victorhugolgr.ead.course.dtos.ModuleDto;
import br.com.victorhugolgr.ead.course.models.CourseModel;
import br.com.victorhugolgr.ead.course.models.ModuleModel;
import br.com.victorhugolgr.ead.course.service.CourseService;
import br.com.victorhugolgr.ead.course.service.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 36000)
@RequiredArgsConstructor
public class ModuleController {

    private final ModuleService moduleService;
    private final CourseService courseService;

    @PostMapping("/courses/{courseId}/modules")
    public ResponseEntity<?> saveModule(@RequestBody @Valid ModuleDto moduleDto, @PathVariable("courseId")UUID courseId) {
        Optional<CourseModel> courseModelOptional = courseService.findById(courseId);
        if(!courseModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course Not Found.");
        }
        var moduleModel = new ModuleModel();
        BeanUtils.copyProperties(moduleDto, moduleModel);
        moduleModel.setCreationDate(LocalDateTime.now(ZoneId.of("UTC")));
        moduleModel.setCourse(courseModelOptional.get());
        return ResponseEntity.status(HttpStatus.CREATED).body(moduleService.save(moduleModel));
    }

    @DeleteMapping("/courses/{courseId}/modules/{moduleId}")
    public ResponseEntity<?> deleteModule(@PathVariable(value = "courseId")UUID courseId, @PathVariable(value = "moduleId")UUID moduleId) {
        Optional<ModuleModel> moduleModelOptional = moduleService.findModuleIntoCourse(courseId, moduleId);
        if(!moduleModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Module not found for this course.");
        }
        moduleService.delete(moduleModelOptional.get());

        return ResponseEntity.status(HttpStatus.OK).body("Module deleted successfully");
    }

    @PutMapping("/courses/{courseId}/modules/{moduleId}")
    public ResponseEntity<?> updateModule(@PathVariable(value = "courseId")UUID courseId,
                                            @PathVariable(value = "moduleId")UUID moduleId,
                                          @RequestBody @Valid ModuleDto moduleDto) {
        Optional<ModuleModel> moduleModelOptional = moduleService.findModuleIntoCourse(courseId, moduleId);
        if(!moduleModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Module not found for this course.");
        }
        var moduleModel = moduleModelOptional.get();
        BeanUtils.copyProperties(moduleDto, moduleModel);
        return ResponseEntity.status(HttpStatus.OK).body(moduleService.save(moduleModel));
    }

    @GetMapping("/courses/{courseId}/modules")
    public ResponseEntity<List<ModuleModel>> getAllModules(@PathVariable(value = "courseId")UUID courseId) {
        return ResponseEntity.status(HttpStatus.OK).body(moduleService.findAllByCourse(courseId));
    }

    @GetMapping("/courses/{courseId}/modules/{moduleId}")
    public ResponseEntity<?> getOneModule(@PathVariable(value = "courseId")UUID courseId, @PathVariable(value = "moduleId")UUID moduleId){
        Optional<ModuleModel> moduleModelOptional = moduleService.findModuleIntoCourse(courseId, moduleId);
        if(!moduleModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Module not found for this course.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(moduleModelOptional.get());
    }
}
