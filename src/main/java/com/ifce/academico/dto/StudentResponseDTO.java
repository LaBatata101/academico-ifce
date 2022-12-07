package com.ifce.academico.dto;

import com.ifce.academico.model.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class StudentResponseDTO {
    private String name;
    private String email;
    private String phone;
    private Calendar birthday;
    private List<DisciplineResponseDTO> disciplines;
}
