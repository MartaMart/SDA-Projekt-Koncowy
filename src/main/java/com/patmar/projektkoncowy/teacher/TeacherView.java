package com.patmar.projektkoncowy.teacher;

import com.patmar.projektkoncowy.schoolclass.SchoolClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeacherView {
    private Long id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private SchoolClass schoolClass;
}