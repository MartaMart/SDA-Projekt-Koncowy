package com.patmar.projektkoncowy.schoolclass;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.patmar.projektkoncowy.student.Student;
import com.patmar.projektkoncowy.subject.Subject;
import com.patmar.projektkoncowy.teacher.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private List<Student> students = new ArrayList<>();

    @OneToMany(mappedBy = "schoolClass", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Subject> subjects = new ArrayList<>();

    public SchoolClass(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

}