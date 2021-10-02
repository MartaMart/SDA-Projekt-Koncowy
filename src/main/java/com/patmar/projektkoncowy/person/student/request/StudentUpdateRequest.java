package com.patmar.projektkoncowy.person.student.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class StudentUpdateRequest extends StudentCreateRequest {
    @NotNull
    private Long id;
}
