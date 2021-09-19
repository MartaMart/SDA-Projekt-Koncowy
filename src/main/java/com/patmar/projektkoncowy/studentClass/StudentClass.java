package com.patmar.projektkoncowy.studentClass;

import com.patmar.projektkoncowy.student.Student;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class StudentClass {

    @Id
    private Long idClass;

    @OneToMany
    private List<Student> students = new ArrayList<>();

}
