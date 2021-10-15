package com.patmar.projektkoncowy.student;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class ErrorResponse {

    String message;
    LocalDateTime dateTime;

}
