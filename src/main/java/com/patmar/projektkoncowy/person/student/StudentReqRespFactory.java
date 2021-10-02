package com.patmar.projektkoncowy.person.student;

import com.patmar.projektkoncowy.person.student.request.StudentCreateRequest;
import com.patmar.projektkoncowy.person.student.request.StudentUpdateRequest;
import com.patmar.projektkoncowy.person.student.response.SimpleStudentResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


public final class StudentReqRespFactory {

    private StudentReqRespFactory() {
    }

    public static StudentDto toDto(StudentCreateRequest req){
        return StudentDto.builder().name(req.getName())
                .surname(req.getSurname())
                .email(req.getEmail())
                .phoneNumber(req.getPhoneNumber())
                .pesel(req.getPesel()).build();
    }

    public static StudentDto toDto(StudentUpdateRequest req){
        return StudentDto.builder().name(req.getName())
                .surname(req.getSurname())
                .email(req.getEmail())
                .phoneNumber(req.getPhoneNumber())
                .pesel(req.getPesel()).id(req.getId()).build();
    }

    public static List<SimpleStudentResponse> simpleAllStudentResponse(List<StudentDto> allStudents) {
        return allStudents.stream().map(StudentReqRespFactory::simpleStudentResponse).collect(Collectors.toList());

    }

    public static SimpleStudentResponse simpleStudentResponse(StudentDto student) {
        return SimpleStudentResponse.builder()
                .name(student.getName())
                .surname(student.getSurname())
                .email(student.getEmail())
                .numberPhone(student.getPhoneNumber())
                .pesel(student.getPesel())
                .build();
    }
}
