package com.patmar.projektkoncowy.person.student.request;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class StudentCreateRequest {
    @NotNull @NotEmpty
    private String name;
    @NotNull @NotEmpty
    private  String surname;
    @NotNull @NotEmpty @Size(min = 5, max = 6)
    private String phoneNumber;
    @Email @NotNull
    private String email;
    @Size(min = 11, max =11)
    private String pesel;
}
