package com.ifce.academico.controller;

import com.ifce.academico.dto.StudentDTO;
import com.ifce.academico.dto.StudentResponseDTO;
import com.ifce.academico.dto.StudentUpdateDTO;
import com.ifce.academico.exception.StudentNotFoundException;
import com.ifce.academico.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/new")
    StudentResponseDTO newStudent(@Valid @RequestBody StudentDTO studentDTO) {
        return new StudentResponseDTO(studentRepository.save(studentDTO.toStudent()));
    }

    @GetMapping("/{id}")
    StudentResponseDTO getStudent(@PathVariable Long id) {
        return new StudentResponseDTO(studentRepository.findById(id)
                                                       .orElseThrow(() -> new StudentNotFoundException(id)));
    }

//    @PatchMapping("/{id}")
//    StudentResponseDTO updateStudent(@PathVariable Long id, @Valid @RequestBody StudentUpdateDTO studentUpdateDTO) {
//
//    }
}
