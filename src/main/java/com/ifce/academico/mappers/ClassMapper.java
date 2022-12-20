package com.ifce.academico.mappers;

import com.ifce.academico.dto.ClassDTO;
import com.ifce.academico.dto.ClassResponseDTO;
import com.ifce.academico.model.Class;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClassMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "course", ignore = true)
    Class classDtoToClass(ClassDTO dto);

    ClassResponseDTO classToClassResponseDto(Class clazz);
}
