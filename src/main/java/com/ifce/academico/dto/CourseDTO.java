package com.ifce.academico.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CourseDTO {
    @NotBlank(message = "name is mandatory")
    private String name;

    private List<ClassDTO> classes = new ArrayList<>();
}
