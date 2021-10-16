package com.patmar.projektkoncowy.schoolclass;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.patmar.projektkoncowy.student.Student;
import com.patmar.projektkoncowy.subject.Subject;
import com.patmar.projektkoncowy.teacher.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "classes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String gradeLevel;

    @OneToOne(mappedBy = "schoolClass", fetch = FetchType.LAZY)
    @JsonIgnore
    private Teacher teacher;

    @OneToMany(mappedBy = "schoolClass", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Student> students;

    @OneToMany(mappedBy = "schoolClass", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Subject> subjects;

    public SchoolClass(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

}