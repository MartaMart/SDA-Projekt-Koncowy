package com.patmar.projektkoncowy.person.student;

import com.patmar.projektkoncowy.person.parent.ParentDto;
import com.patmar.projektkoncowy.studentClass.StudentClassDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDto {
    private Long id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private String pesel;
    private ParentDto parentDto;
    private StudentClassDto studentClassDto;

    public static StudentDto toDto(Student student) {
       return StudentDto.builder()
                .id(student.getId())
                .name(student.getPersonData().getName())
                .surname(student.getPersonData().getSurname())
                .phoneNumber(student.getPersonData().getPhoneNumber())
                .email(student.getPersonData().getEmail())
                .pesel(student.getPesel())
                .parentDto(ParentDto.toDto(student.getParent()))
                .studentClassDto(StudentClassDto.toDto(student.getStudentClass()))
                .build();
    }

}