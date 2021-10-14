package com.patmar.projektkoncowy.student;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class StudentCreateRequest {

    @Size(min = 2, max = 20, message = "Name length should be between 0 and 20")
    @NotNull
    String name;

    @Size(min = 2, max = 20, message = "Surname length should be between 0 and 20")
    @NotNull
    String surName;


}
