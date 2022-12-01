package com.ifce.academico.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Long id) {
        super("Could not find student with id: " + id);
    }
}
