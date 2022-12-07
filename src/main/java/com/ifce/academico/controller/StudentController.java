package com.ifce.academico.controller;

import com.ifce.academico.dto.StudentDTO;
import com.ifce.academico.dto.StudentResponseDTO;
import com.ifce.academico.dto.StudentUpdateDTO;
import com.ifce.academico.exception.StudentNotFoundException;
import com.ifce.academico.mappers.StudentMapper;
import com.ifce.academico.model.Student;
import com.ifce.academico.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/student")
public class StudentController {

    final StudentRepository studentRepository;

    final StudentMapper studentMapper;

    @Autowired
    public StudentController(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/new")
    StudentResponseDTO newStudent(@Valid @RequestBody StudentDTO studentDTO) {
        return studentMapper.studentToStudentResponseDto(studentRepository
                                                                 .save(studentMapper.studentDtoToStudent(studentDTO)));
    }

    @GetMapping("/{id}")
    StudentResponseDTO getStudent(@PathVariable Long id) {
        return studentRepository.findById(id).map(studentMapper::studentToStudentResponseDto)
                                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @GetMapping("/")
    List<StudentResponseDTO> getAllStudents() {
        return studentRepository.findAll().stream().map(studentMapper::studentToStudentResponseDto)
                                .collect(Collectors.toList());
    }

    @PatchMapping("/{id}")
    StudentResponseDTO updateStudent(@PathVariable Long id, @Valid @RequestBody StudentUpdateDTO studentUpdateDTO) {
        Student studentFromDb = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
        Student updatedStudent = studentMapper.studentUpdateDtoToStudent(studentUpdateDTO, studentFromDb);
        updatedStudent.setId(studentFromDb.getId());

        return studentMapper.studentToStudentResponseDto(studentRepository.save(updatedStudent));
    }
}
