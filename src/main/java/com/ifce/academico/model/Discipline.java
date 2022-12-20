package com.ifce.academico.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tbl_discipline")
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;
    private int workload;

    @ManyToMany
    private List<Professor> professors;

    @ManyToMany(mappedBy = "disciplines")
    private List<Curriculum> curriculumList;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Student> students;
}
