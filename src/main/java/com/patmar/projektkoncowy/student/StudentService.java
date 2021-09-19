package com.patmar.projektkoncowy.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class StudentService {

    private final StudentRepository repository;

    public void add(StudentCreateRequest request) {
        
    }


}
