package com.ifce.academico.dto;

import com.ifce.academico.model.Discipline;
import com.ifce.academico.model.Student;
import lombok.Getter;

import java.util.Calendar;
import java.util.List;

@Getter
public class StudentResponseDTO {
    private String name;
    private String email;
    private String phone;
    private Calendar birthday;
    private List<Discipline> disciplines;

    public StudentResponseDTO(Student student) {
        name = student.getName();
        email  = student.getEmail();
        phone = student.getPhone();
        birthday = student.getBirthday();
        disciplines = student.getDisciplines();
    }
}
