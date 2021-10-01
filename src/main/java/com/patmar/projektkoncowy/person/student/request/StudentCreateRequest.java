package com.patmar.projektkoncowy.person.student.request;

import lombok.Data;

@Data
public class StudentCreateRequest {
    private String name;
    private  String surname;
    private String phoneNumber;
    private String email;
    private String pesel;
}
