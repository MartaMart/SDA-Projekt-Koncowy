package com.patmar.projektkoncowy.teacher;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.patmar.projektkoncowy.configuration.Role;
import com.patmar.projektkoncowy.schoolclass.SchoolClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @JsonIgnore
    private Role role;

    @OneToOne
    @JoinColumn(name = "class_id")
    @JsonIgnore
    private SchoolClass schoolClass;

    public Teacher(String name, String surname, String phoneNumber, String email, SchoolClass schoolClass) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.schoolClass = schoolClass;
    }
}