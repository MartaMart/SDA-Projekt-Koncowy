package com.patmar.projektkoncowy.person.student;

import com.patmar.projektkoncowy.person.student.request.StudentCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


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
    public void updateStudent(StudentDto studentDto) {

        repository.save(student);
    }
    public void deleteStudent(Long id) {
        repository.delete(id);
    }

    public void createStudent(StudentDto studentDto) {

    }
}
