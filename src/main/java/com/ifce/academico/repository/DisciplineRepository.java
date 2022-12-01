package com.ifce.academico.repository;

import com.ifce.academico.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
}
