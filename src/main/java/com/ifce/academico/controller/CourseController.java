package com.ifce.academico.controller;

import com.ifce.academico.dto.ClassDTO;
import com.ifce.academico.dto.CourseDTO;
import com.ifce.academico.dto.CourseResponseDTO;
import com.ifce.academico.exception.CourseNotFoundException;
import com.ifce.academico.mappers.ClassMapper;
import com.ifce.academico.mappers.CourseMapper;
import com.ifce.academico.model.Class;
import com.ifce.academico.model.Course;
import com.ifce.academico.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private ClassMapper classMapper;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/new")
    CourseResponseDTO newCourse(@Valid @RequestBody CourseDTO courseDTO) {
        Course course = courseMapper.courseDtoToCourse(courseDTO);

        if (course.getClasses() != null) {
            course.getClasses().forEach(clazz -> {
                clazz.setCourse(course);
            });
        }

        return courseMapper.courseToCourseResponseDto(courseRepository.save(course));
    }

    @GetMapping("/")
    List<CourseResponseDTO> getAllCourses() {
        return courseRepository.findAll()
                               .stream()
                               .map(courseMapper::courseToCourseResponseDto)
                               .collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{course_id}/class/new")
    CourseResponseDTO createClassForCourse(@PathVariable Long course_id, @RequestBody ClassDTO dto) {
        Course course = courseRepository.findById(course_id).orElseThrow(() -> new CourseNotFoundException(course_id));

        Class newClass = classMapper.classDtoToClass(dto);
        newClass.setCourse(course);

        course.getClasses().add(newClass);

        return courseMapper.courseToCourseResponseDto(course);
    }

}
