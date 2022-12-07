package com.ifce.academico.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

@Setter
@Getter
public class StudentUpdateDTO {
    private String name;
    private String email;
    private String phone;
    private Calendar birthday;
}
