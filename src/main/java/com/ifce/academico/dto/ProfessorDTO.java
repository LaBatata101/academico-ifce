package com.ifce.academico.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class ProfessorDTO {
    @NotBlank(message = "name is mandatory")
    private String name;

    @Email
    @NotBlank(message = "email is mandatory")
    private String email;

    @Pattern(regexp = "\\([0-9]{2}\\) [0-9]{5}-[0-9]{4}", message = "Invalid phone number")
    @NotBlank(message = "phone number is mandatory")
    private String phone;
}
