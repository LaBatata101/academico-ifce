package com.ifce.academico.mappers;

import com.ifce.academico.dto.StudentDTO;
import com.ifce.academico.dto.StudentResponseDTO;
import com.ifce.academico.dto.StudentUpdateDTO;
import com.ifce.academico.model.Student;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Mapping(target = "disciplines", ignore = true)
    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Student studentUpdateDtoToStudent(StudentUpdateDTO dto, @MappingTarget Student student);

    StudentResponseDTO studentToStudentResponseDto(Student student);

    @Mapping(target = "id", ignore = true)
    Student studentDtoToStudent(StudentDTO dto);
}
