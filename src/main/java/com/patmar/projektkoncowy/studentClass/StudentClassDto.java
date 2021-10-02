package com.patmar.projektkoncowy.studentClass;

import com.patmar.projektkoncowy.person.student.StudentDto;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class StudentClassDto {
    public Long id;

    private final Integer year;

    private final String classSymbol;

    private final LocalDate schoolYearBook;

    private final List<StudentDto> students;

public static StudentClassDto toDto(StudentClass studentClass) {
        return StudentClassDto.builder()
                .id(studentClass.getId())
                .classSymbol(studentClass.getClassSymbol())
                .year(studentClass.getYear())
                .schoolYearBook(studentClass.getSchoolYearBook())
                .students(studentClass.getStudents()
                        .stream()
                        .map(StudentDto::toDto).collect(Collectors.toList()))
                .build();
    }
}
