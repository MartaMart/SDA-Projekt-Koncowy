package com.patmar.projektkoncowy.teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherRequestBody {
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private Long classId;
}