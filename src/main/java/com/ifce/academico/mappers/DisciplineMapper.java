package com.ifce.academico.mappers;


import com.ifce.academico.dto.DisciplineDTO;
import com.ifce.academico.dto.DisciplineResponseDTO;
import com.ifce.academico.model.Discipline;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DisciplineMapper {
    DisciplineResponseDTO disciplineToDisciplineResponseDto(Discipline discipline);

    @Mapping(target = "curriculumList", ignore = true)
    @Mapping(target = "professors", ignore = true)
    @Mapping(target = "students", ignore = true)
    @Mapping(target = "id", ignore = true)
    Discipline disciplineDtoToDiscipline(DisciplineDTO dto);
}
