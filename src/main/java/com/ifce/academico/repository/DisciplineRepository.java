package com.ifce.academico.repository;

import com.ifce.academico.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {

    @Query("SELECT d FROM Discipline as d WHERE d.name = :name")
    Optional<Discipline> findByName(@Param("name") String name);

    @Query("SELECT d FROM Discipline as d WHERE d.name IN :names")
    List<Discipline> findAllByNames(@Param("names") List<String> names);
}
