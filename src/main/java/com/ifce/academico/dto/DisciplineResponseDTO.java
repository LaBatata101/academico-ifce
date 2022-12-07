package com.ifce.academico.dto;

import com.ifce.academico.model.Discipline;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DisciplineResponseDTO {
    private String name;
    private int workload;
}
