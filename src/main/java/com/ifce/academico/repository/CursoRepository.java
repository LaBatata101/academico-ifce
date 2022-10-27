package com.ifce.academico.repository;

import com.ifce.academico.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Long, Curso> {
}
