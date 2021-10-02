package com.patmar.projektkoncowy.subject;

import com.patmar.projektkoncowy.schoolclass.SchoolClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "subjects")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(nullable = false, unique = true)
    private String subjectName;


    @ManyToOne
    @JoinColumn(name = "schoolClass_id")
    private SchoolClass schoolClass;


}
