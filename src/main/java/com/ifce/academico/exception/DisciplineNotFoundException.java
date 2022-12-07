package com.ifce.academico.exception;

public class DisciplineNotFoundException extends RuntimeException {

    public DisciplineNotFoundException(Long id) {
        super("Could not find discipline with id: " + id);
    }
}
