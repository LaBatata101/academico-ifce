package com.ifce.academico.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

@Getter
@Setter
public class CurriculumResponseDTO {
    private String name;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Calendar date;
}
