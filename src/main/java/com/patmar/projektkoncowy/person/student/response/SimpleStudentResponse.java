package com.patmar.projektkoncowy.person.student.response;

import lombok.Builder;

@Builder
public class SimpleStudentResponse {
    private final String name;
    private final String surname;
    private final String numberPhone;
    private final String email;
    private final String pesel;
}
