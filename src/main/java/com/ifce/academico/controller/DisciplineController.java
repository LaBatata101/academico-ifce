package com.ifce.academico.controller;

import com.ifce.academico.dto.DisciplineDTO;
import com.ifce.academico.dto.DisciplineResponseDTO;
import com.ifce.academico.dto.StudentResponseDTO;
import com.ifce.academico.exception.DisciplineNotFoundException;
import com.ifce.academico.exception.StudentNotFoundException;
import com.ifce.academico.mappers.DisciplineMapper;
import com.ifce.academico.mappers.StudentMapper;
import com.ifce.academico.model.Discipline;
import com.ifce.academico.model.Student;
import com.ifce.academico.repository.DisciplineRepository;
import com.ifce.academico.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/discipline")
public class DisciplineController {
    final DisciplineRepository disciplineRepository;
    final StudentRepository studentRepository;

    final StudentMapper studentMapper;

    final DisciplineMapper disciplineMapper;

    @Autowired
    public DisciplineController(
            DisciplineRepository disciplineRepository, StudentRepository studentRepository,
            StudentMapper studentMapper, DisciplineMapper disciplineMapper
                               ) {
        this.disciplineRepository = disciplineRepository;
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.disciplineMapper = disciplineMapper;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/new")
    DisciplineResponseDTO newStudent(@Valid @RequestBody DisciplineDTO studentDTO) {
        return disciplineMapper
                .disciplineToDisciplineResponseDto(disciplineRepository
                                                           .save(disciplineMapper
                                                                         .disciplineDtoToDiscipline(studentDTO)));
    }

    @GetMapping("/")
    List<DisciplineResponseDTO> getAllDisciplines() {
        return disciplineRepository.findAll().stream().map(disciplineMapper::disciplineToDisciplineResponseDto)
                                   .collect(Collectors.toList());
    }

    @PostMapping("/{discipline_id}/student/{student_id}")
    StudentResponseDTO addStudentToDiscipline(@PathVariable Long discipline_id, @PathVariable Long student_id) {
        Discipline disciplineFromDb = disciplineRepository.findById(discipline_id)
                                                          .orElseThrow(
                                                                  () -> new DisciplineNotFoundException(discipline_id));
        Student studentFromDb = studentRepository.findById(student_id)
                                                 .orElseThrow(() -> new StudentNotFoundException(student_id));

        disciplineFromDb.getStudents().add(studentFromDb);
        disciplineRepository.save(disciplineFromDb);

        studentFromDb.getDisciplines().add(disciplineFromDb);

        return studentMapper.studentToStudentResponseDto(studentFromDb);
    }
}
