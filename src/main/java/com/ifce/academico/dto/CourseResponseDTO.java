package com.ifce.academico.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CourseResponseDTO {
    private String name;

    private List<ClassResponseDTO> classes;
}
