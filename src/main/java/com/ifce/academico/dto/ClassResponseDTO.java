package com.ifce.academico.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClassResponseDTO {
    private String name;

    private List<DisciplineResponseDTO> disciplines;
}
