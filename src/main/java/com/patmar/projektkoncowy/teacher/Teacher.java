package com.patmar.projektkoncowy.teacher;

import com.patmar.projektkoncowy.configuration.Role;
import com.patmar.projektkoncowy.subject.Subject;
import com.patmar.projektkoncowy.timetable.Timetable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teachers")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String phoneNumber;
    private String email;

    @Enumerated(EnumType.STRING)
    @ColumnDefault(value = "'ROLE_TEACHER'")
    private Role role;

    @ManyToMany(mappedBy = "teachers")
    private Set<Subject> subjects = new HashSet<>();

    @OneToMany(mappedBy = "teacher")
    private Set<Timetable> timetables = new HashSet<>();

    public Teacher(String name, String surname, String phoneNumber, String email) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
