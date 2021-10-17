package com.patmar.projektkoncowy.student;

import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.patmar.projektkoncowy.student.StudentMapper.MAPPER;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public void addStudent (StudentCreateRequest request) {
        Student student = MAPPER.toStudent(request);
        repository.save(student);
    }
    public void updateStudent (Student student) {
        repository.save(student);
    }

    public List<StudentView> findAll() {
        return repository.findAll()
                .stream()
                .map(MAPPER::toStudentListView)
                .collect(Collectors.toList());
    }

    public void deleteStudent (Student student) {
        repository.delete(student);
    }

    public List<StudentView> getStudent(Long id) {
        return repository.findById(id)
                .stream()
                 .map(MAPPER::toStudentSingleView)
                .collect(Collectors.toList());
    }
}
