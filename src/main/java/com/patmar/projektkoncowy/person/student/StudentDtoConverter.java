package com.patmar.projektkoncowy.person.student;

import com.patmar.projektkoncowy.person.student.request.StudentCreateRequest;
import com.patmar.projektkoncowy.person.student.request.StudentUpdateRequest;
import org.springframework.stereotype.Component;

@Component
public class StudentDtoConverter {
    public StudentDto toStudentDto(StudentCreateRequest req){
        return StudentDto.builder().name(req.getName())
                .surname(req.getSurname())
                .email(req.getEmail())
                .phoneNumber(req.getPhoneNumber())
                .pesel(req.getPesel()).build();
    }

    public StudentDto toStudentDto(StudentUpdateRequest req){
        return StudentDto.builder().name(req.getName())
                .surname(req.getSurname())
                .email(req.getEmail())
                .phoneNumber(req.getPhoneNumber())
                .pesel(req.getPesel()).id(req.getId()).build();
    }
}
