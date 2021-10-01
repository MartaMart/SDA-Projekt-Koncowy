package com.patmar.projektkoncowy.person.student;

import com.patmar.projektkoncowy.commons.EntityBase;
import com.patmar.projektkoncowy.person.PersonData;
import com.patmar.projektkoncowy.person.parent.Parent;
import com.patmar.projektkoncowy.studentClass.StudentClass;
import lombok.*;
import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Setter
@Getter
@Table(name = "students")
public class Student extends EntityBase {

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private PersonData personData;

    private String pesel;

    @ManyToOne
    @JoinColumn(name="parent_id", nullable=false)
    private Parent parent;

    @ManyToOne
    @JoinColumn(name = "student_classes" )
    private StudentClass studentClass;
}