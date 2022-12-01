package com.ifce.academico.repository;

import com.ifce.academico.model.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculumRepository extends JpaRepository<Curriculum, Long> {
}
