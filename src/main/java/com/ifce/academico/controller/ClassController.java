package com.ifce.academico.controller;

import com.ifce.academico.dto.ClassDTO;
import com.ifce.academico.dto.ClassResponseDTO;
import com.ifce.academico.exception.CourseNotFoundException;
import com.ifce.academico.mappers.ClassMapper;
import com.ifce.academico.model.Class;
import com.ifce.academico.model.Course;
import com.ifce.academico.repository.ClassRepository;
import com.ifce.academico.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    private ClassRepository classRepository;
    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private CourseRepository courseRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/new")
    ClassResponseDTO newClass(@Valid @RequestBody ClassDTO classDTO) {
        String courseName = classDTO.getCourse().getName();
        Course course = courseRepository.findByName(courseName)
                                        .orElseThrow(() -> new CourseNotFoundException(courseName));

        Class clazz = classMapper.classDtoToClass(classDTO);
        clazz.setCourse(course);

        return classMapper.classToClassResponseDto(classRepository.save(clazz));
    }

    @GetMapping("/")
    List<ClassResponseDTO> getAllClasses() {
        return classRepository.findAll()
                              .stream().map(classMapper::classToClassResponseDto).collect(Collectors.toList());
    }
}
