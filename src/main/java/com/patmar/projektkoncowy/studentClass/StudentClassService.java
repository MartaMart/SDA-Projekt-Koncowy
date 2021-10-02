package com.patmar.projektkoncowy.studentClass;

import org.springframework.stereotype.Service;

@Service
public class StudentClassService {
    private StudentClassRepository repository;

    public StudentClass getStudentClassById(Long id) {
       return repository.getById(id);
    }
}
