package com.ifce.academico.repository;

import com.ifce.academico.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Long, Aluno> {
}
