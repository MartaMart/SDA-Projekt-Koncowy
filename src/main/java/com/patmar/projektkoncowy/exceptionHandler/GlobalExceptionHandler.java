package com.patmar.projektkoncowy.exceptionHandler;

import com.patmar.projektkoncowy.schoolclass.SchoolClassNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SchoolClassNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ExceptionBody handleClassNotFoundException(SchoolClassNotFoundException e) {
        return new ExceptionBody(List.of(e.getMessage()), LocalDateTime.now());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ExceptionBody handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        List<String> errorMessages = allErrors.stream().map(m -> m.getDefaultMessage()).collect(Collectors.toList());
        return new ExceptionBody(errorMessages, LocalDateTime.now());
    }

}