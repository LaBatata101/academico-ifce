package com.ifce.academico.repository;

import com.ifce.academico.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("SELECT d FROM Course as d WHERE d.name = :name")
    Optional<Course> findByName(@Param("name") String name);
}
