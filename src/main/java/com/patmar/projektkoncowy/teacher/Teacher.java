package com.patmar.projektkoncowy.teacher;

import com.patmar.projektkoncowy.configuration.Role;
import com.patmar.projektkoncowy.schoolclass.SchoolClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

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

    @OneToOne
    @JoinColumn(name = "class_id")
    private SchoolClass schoolClass;
}
