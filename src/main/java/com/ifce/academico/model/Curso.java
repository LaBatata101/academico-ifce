package com.ifce.academico.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<MatrizCurricular> matrizesCurriculares;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Turma> turmas;
}
