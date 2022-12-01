package com.ifce.academico.handler;

import com.ifce.academico.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class StudentNotFoundHandler {

    @ResponseBody
    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    Map<String, String> studentNotFoundHandler(StudentNotFoundException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("msg", ex.getMessage());
        return errors;
    }
}