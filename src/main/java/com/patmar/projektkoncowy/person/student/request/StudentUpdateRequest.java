package com.patmar.projektkoncowy.person.student.request;

import lombok.Data;

@Data
public class StudentUpdateRequest extends StudentCreateRequest {
    private Long id;
}
