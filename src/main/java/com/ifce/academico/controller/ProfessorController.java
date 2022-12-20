package com.ifce.academico.controller;

import com.ifce.academico.dto.ProfessorDTO;
import com.ifce.academico.dto.ProfessorResponseDTO;
import com.ifce.academico.mappers.ProfessorMapper;
import com.ifce.academico.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private ProfessorMapper professorMapper;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/new")
    ProfessorResponseDTO newProfessor(@Valid @RequestBody ProfessorDTO professorDTO) {
        return professorMapper
                .professorToProfessorResponseDto(professorRepository
                                                         .save(professorMapper.professorDtoToProfessor(professorDTO)));
    }

    @GetMapping("/")
    List<ProfessorResponseDTO> getAllProfessor() {
        return professorRepository
                .findAll()
                .stream()
                .map(professorMapper::professorToProfessorResponseDto).collect(Collectors.toList());
    }
}
