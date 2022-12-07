package com.ifce.academico.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ifce.academico.model.Discipline;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Calendar;
import java.util.List;

@Getter
public class StudentDTO {
    @NotBlank(message = "name is mandatory")
    private String name;

    @Email
    @NotBlank(message = "email is mandatory")
    private String email;

    @Pattern(regexp = "\\([0-9]{2}\\)[0-9]{9}|[0-9]{9}", message = "Invalid phone number")
    @NotBlank(message = "phone number is mandatory")
    private String phone;

    @NotNull(message = "birthday is mandatory")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Calendar birthday;

    private List<Discipline> disciplines;
}
