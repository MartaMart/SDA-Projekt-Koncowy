package com.patmar.projektkoncowy.person.student;



import com.patmar.projektkoncowy.person.student.request.StudentCreateRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService service;
    private final StudentDtoConverter converter;

    public StudentController(StudentService service, StudentDtoConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @PostMapping
    void createStudent(@RequestBody StudentCreateRequest studentCreateRequest) {
        service.createStudent(converter.toStudentDto(studentCreateRequest));
    };

    @PutMapping
    void updateStudent (@RequestBody Student student) {
        service.updateStudent(student);
    }

    @DeleteMapping("/{id}")
    void deleteAuthor (@PathVariable Long id) {
        service.deleteStudent(id);
    }

}
