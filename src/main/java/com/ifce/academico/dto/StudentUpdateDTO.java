package com.ifce.academico.dto;

import com.ifce.academico.model.Discipline;

import java.util.Calendar;
import java.util.List;

public class StudentUpdateDTO {
    private String name;
    private String email;
    private String phone;
    private Calendar birthday;
    private List<Discipline> disciplines;
}
