package com.patmar.projektkoncowy.exceptionHandler;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Data
public class ExceptionBody {
    private final List<String> message;
    private final LocalDateTime localDateTime;
}