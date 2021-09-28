package com.patmar.projektkoncowy.timetable;

import com.patmar.projektkoncowy.lessonHours.LessonHour;
import com.patmar.projektkoncowy.schoolclass.SchoolClass;
import com.patmar.projektkoncowy.subject.Subject;
import com.patmar.projektkoncowy.teacher.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "timetables")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private DayOfWeek dayOfWeek;

    @ManyToOne
    private LessonHour lessonHour;

    @ManyToOne
    private SchoolClass schoolClass;

    @ManyToOne
    private Subject subject;

    @ManyToOne
    private Teacher teacher;

}
