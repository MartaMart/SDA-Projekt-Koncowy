package com.patmar.projektkoncowy.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
@RequiredArgsConstructor

public class StudentService {

    private final StudentRepository repository;

//    public void add(StudentCreateRequest request) {
//        Student student = MAPPER.toStudent(request);
//        repository.save(student);
//    }
//    public void findAll(List<Student>) {
//
//    }
    public void updateStudent(Student student) {
        repository.save(student);
    }
    public void deleteStudent(Student student) {
        repository.delete(student);
    }
}
