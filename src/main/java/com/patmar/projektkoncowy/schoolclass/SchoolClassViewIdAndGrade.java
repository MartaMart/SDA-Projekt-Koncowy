package com.patmar.projektkoncowy.schoolclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SchoolClassViewIdAndGrade {
    private Long id;
    private String gradeLevel;
}