package com.patmar.projektkoncowy.schoolclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SchoolClassRequestBody {

    @NotBlank(message = "Class must not be null and to have white spaces.")
    @Size(min = 1, max = 2, message = "Class must be between 1 and 2 characters long.")
    @GradeLevelConstraint
    private String gradeLevel;
}