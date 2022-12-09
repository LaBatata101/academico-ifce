package com.ifce.academico.mappers;

import com.ifce.academico.dto.CourseDTO;
import com.ifce.academico.dto.CourseResponseDTO;
import com.ifce.academico.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "curriculumList", ignore = true)
    Course courseDtoToCourse(CourseDTO dto);

    CourseResponseDTO courseToCourseResponseDto(Course course);
}
