package com.patmar.projektkoncowy.exceptionHandler;

import com.patmar.projektkoncowy.schoolclass.SchoolClassNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SchoolClassNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ExceptionBody handleClassNotFoundException(SchoolClassNotFoundException e) {
        return new ExceptionBody(List.of(e.getMessage()), LocalDateTime.now());
    }

}
