package com.patmar.projektkoncowy.lessonHours;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "lesson_hours")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LessonHour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(unique = true, nullable = false)
    private Short lessonNumber;

    @Column(unique = true, nullable = false)
    private LocalTime startLesson;

    @Column(unique = true, nullable = false)
    private LocalTime endLesson;

}
