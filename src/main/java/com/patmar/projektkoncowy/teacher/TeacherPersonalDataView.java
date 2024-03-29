package com.patmar.projektkoncowy.teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeacherPersonalDataView {
    private Long id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
}