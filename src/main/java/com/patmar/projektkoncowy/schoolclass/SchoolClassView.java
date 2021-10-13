package com.patmar.projektkoncowy.schoolclass;

import com.patmar.projektkoncowy.student.Student;
import com.patmar.projektkoncowy.subject.Subject;
import com.patmar.projektkoncowy.teacher.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SchoolClassView {
    private Long id;
    private String gradeLevel;
    private Teacher teacher;
    private Set<Student> students;
    private Set<Subject> subjects;
}
