package com.patmar.projektkoncowy.studentClass;

import com.patmar.projektkoncowy.commons.EntityBase;
import com.patmar.projektkoncowy.person.student.Student;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class StudentClass extends EntityBase {

    @OneToMany(mappedBy = "studentClass", fetch = FetchType.LAZY)
    private List<Student> students = new ArrayList<>();

}
