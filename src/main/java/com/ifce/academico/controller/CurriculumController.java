package com.ifce.academico.controller;

import com.ifce.academico.dto.CurriculumDTO;
import com.ifce.academico.dto.CurriculumResponseDTO;
import com.ifce.academico.dto.DisciplineDTO;
import com.ifce.academico.exception.CourseNotFoundException;
import com.ifce.academico.mappers.CurriculumMapper;
import com.ifce.academico.model.Course;
import com.ifce.academico.model.Curriculum;
import com.ifce.academico.model.Discipline;
import com.ifce.academico.repository.CourseRepository;
import com.ifce.academico.repository.CurriculumRepository;
import com.ifce.academico.repository.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/curriculum")
public class CurriculumController {
    @Autowired
    private CurriculumRepository curriculumRepository;

    @Autowired
    private CurriculumMapper curriculumMapper;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private DisciplineRepository disciplineRepository;

    @PostMapping("/new")
    private CurriculumResponseDTO newCurriculum(@Valid @RequestBody CurriculumDTO curriculumDTO) {
        String courseName = curriculumDTO.getCourse().getName();
        Course course = courseRepository.findByName(courseName)
                                        .orElseThrow(() -> new CourseNotFoundException(courseName));
        List<Discipline> disciplines = disciplineRepository.findAllByNames(curriculumDTO.getDisciplines()
                                                                                        .stream()
                                                                                        .map(DisciplineDTO::getName)
                                                                                        .collect(Collectors.toList()));

        Curriculum curriculum = curriculumMapper.curriculumDtoToCurriculum(curriculumDTO);
        curriculum.setCourse(course);
        curriculum.setDisciplines(disciplines);

        return curriculumMapper.curriculumToCurriculumResponseDto(curriculumRepository.save(curriculum));
    }

    @GetMapping("/")
    private List<CurriculumResponseDTO> getAllCurriculums() {
        return curriculumRepository.findAll().stream().map(curriculumMapper::curriculumToCurriculumResponseDto)
                                   .collect(Collectors.toList());
    }
}
