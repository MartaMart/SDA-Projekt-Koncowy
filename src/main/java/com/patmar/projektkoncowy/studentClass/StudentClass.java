package com.patmar.projektkoncowy.studentClass;

import com.patmar.projektkoncowy.commons.EntityBase;
import com.patmar.projektkoncowy.person.student.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StudentClass extends EntityBase {

    private Integer year;

    private String classSymbol;

    private LocalDate schoolYearBook;

    @OneToMany(mappedBy = "studentClass", fetch = FetchType.LAZY)
    private List<Student> students;

}
