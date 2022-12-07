package com.ifce.academico.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tbl_professor")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "name is mandatory")
    private String name;

    @Email
    @NotBlank(message = "email is mandatory")
    private String email;

    @Pattern(regexp = "\\([0-9]{2}\\)[0-9]{9}|[0-9]{9}", message = "Invalid phone number")
    @NotBlank(message = "phone number is mandatory")
    private String phone;

    @ManyToMany(mappedBy = "professors")
    private List<Discipline> disciplines;
}
