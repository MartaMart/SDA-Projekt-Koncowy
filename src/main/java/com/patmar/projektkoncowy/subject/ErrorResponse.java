package com.patmar.projektkoncowy.subject;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class ErrorResponse {

    String message;
    LocalDateTime dateTime;

}
