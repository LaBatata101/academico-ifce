package com.ifce.academico.mappers;

import com.ifce.academico.dto.CurriculumDTO;
import com.ifce.academico.dto.CurriculumResponseDTO;
import com.ifce.academico.model.Curriculum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CurriculumMapper {
    @Mapping(target = "date", source = "currentDate")
    CurriculumResponseDTO curriculumToCurriculumResponseDto(Curriculum curriculum);

    @Mapping(target = "id", ignore = true)
    Curriculum curriculumDtoToCurriculum(CurriculumDTO dto);
}
