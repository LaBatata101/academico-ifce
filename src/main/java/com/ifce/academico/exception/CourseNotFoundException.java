package com.ifce.academico.exception;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(Long id) {
        super("Could not find course with id: " + id);
    }

    public CourseNotFoundException(String name) {
        super("Could not find course: " + name);
    }
}
