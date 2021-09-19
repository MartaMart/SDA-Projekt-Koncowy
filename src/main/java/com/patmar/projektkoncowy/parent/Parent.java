package com.patmar.projektkoncowy.parent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "parents")
public class Parent {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String email;

    private String phoneNumber;

//    @OneToMany
//    private List<Student> students = new ArrayList<>();
//    @OneToOne(orphanRemoval = true)
//    @JoinColumn(name = "pesel_ID")
//    private Student pesel;
}
