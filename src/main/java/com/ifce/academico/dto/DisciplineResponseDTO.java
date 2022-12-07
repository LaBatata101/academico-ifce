package com.ifce.academico.dto;

import com.ifce.academico.model.Discipline;
import lombok.Getter;

@Getter
public class DisciplineResponseDTO {
    private String name;
    private int workload;

    public DisciplineResponseDTO(Discipline discipline) {
        this.name = discipline.getName();
        this.workload = discipline.getWorkload();
    }
}
