package com.ifce.academico.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToMany(mappedBy = "disciplinas")
    private List<MatrizCurricular> matrizesCurriculares;

    @ManyToMany
    private List<Professor> professores;

    @ManyToMany
    private List<Aluno> alunos;
}
