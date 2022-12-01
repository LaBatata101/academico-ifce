package com.ifce.academico.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tbl_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String phone;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar birthday;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Discipline> disciplines;

    public Student(String name, String email, String phone, Calendar birthday) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
    }
}
