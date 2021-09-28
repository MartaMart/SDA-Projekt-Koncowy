package com.patmar.projektkoncowy.schoolclass;

import com.patmar.projektkoncowy.timetable.Timetable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "school_classes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    private String gradeLevel;

    @OneToMany(mappedBy = "schoolClass")
    private List<Timetable> timetableList = new ArrayList<>();

    public SchoolClass(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }
}
