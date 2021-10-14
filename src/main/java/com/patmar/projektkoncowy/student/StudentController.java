package com.patmar.projektkoncowy.student;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/api/students")
public class StudentController {

    private  StudentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent ( @RequestBody @Valid StudentCreateRequest request) {
         service.addStudent(request);
    }

    @GetMapping
    public List<StudentView> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public List<StudentView> getOne(@PathVariable Long id) {
        return service.getStudent(id);
    }

    @PutMapping
    void updateStudent (@RequestBody @Valid Student student) {
        service.updateStudent(student);
    }

    @DeleteMapping
    void deleteStudent (Student student) {
        service.deleteStudent(student);
    }
}
