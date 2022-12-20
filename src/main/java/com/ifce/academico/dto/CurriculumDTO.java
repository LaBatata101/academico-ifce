package com.ifce.academico.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Getter
@Setter
public class CurriculumDTO {
    @NotBlank(message = "name is mandatory")
    private String name;

    @NotNull(message = "birthday is mandatory")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Calendar currentDate;

    private List<DisciplineDTO> disciplines = new ArrayList<>();

    private CourseDTO course;
}
