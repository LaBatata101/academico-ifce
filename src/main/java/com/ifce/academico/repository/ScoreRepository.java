package com.ifce.academico.repository;

import com.ifce.academico.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Long> {
}
