package com.patmar.projektkoncowy.exceptionHandler;

import com.patmar.projektkoncowy.teacher.TeacherNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TeacherNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ExceptionBody handleTeacherNotFoundException(TeacherNotFoundException e) {
        return new ExceptionBody(List.of(e.getMessage()), LocalDateTime.now());
    }

}
