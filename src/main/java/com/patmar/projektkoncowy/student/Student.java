package com.patmar.projektkoncowy.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String email;

    private String pesel;

//  @OneToOne(mappedBy = "pesel")
//  @JoinColumn(name = "parent")
//        private Parent parent;
//
}