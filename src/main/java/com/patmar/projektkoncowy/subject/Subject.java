package com.patmar.projektkoncowy.subject;

import com.patmar.projektkoncowy.teacher.Teacher;
import com.patmar.projektkoncowy.timetable.Timetable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToMany
    @JoinTable
    private Set<Teacher> teachers = new HashSet<>();

    @OneToMany(mappedBy = "subject")
    private List<Timetable> timetable = new ArrayList<>();

}
