package com.ifce.academico.mappers;

import com.ifce.academico.dto.ProfessorDTO;
import com.ifce.academico.dto.ProfessorResponseDTO;
import com.ifce.academico.model.Professor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProfessorMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "disciplines", ignore = true)
    Professor professorDtoToProfessor(ProfessorDTO dto);

    ProfessorResponseDTO professorToProfessorResponseDto(Professor professor);
}
