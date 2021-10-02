package com.patmar.projektkoncowy.person.student;


import com.patmar.projektkoncowy.person.student.request.StudentCreateRequest;
import com.patmar.projektkoncowy.person.student.request.StudentUpdateRequest;
import com.patmar.projektkoncowy.person.student.response.SimpleStudentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.patmar.projektkoncowy.person.student.StudentReqRespFactory.toDto;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService service;


    public StudentController(StudentService service ) {
        this.service = service;

    }

    @PostMapping
    public void createStudent(@RequestBody @Valid StudentCreateRequest studentCreateRequest) {
        service.createStudent(toDto(studentCreateRequest));
    };

    @PutMapping
    public void updateStudent (@RequestBody @Valid StudentUpdateRequest studentUpdateRequest) {
        service.updateStudent(toDto(studentUpdateRequest));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAuthor (@PathVariable Long id) {
        service.deleteStudent(id);
    }

    @GetMapping
    public ResponseEntity<List<SimpleStudentResponse>> getAllStudents(){
        return ResponseEntity.ok(StudentReqRespFactory.simpleAllStudentResponse(service.getAllStudents()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SimpleStudentResponse> getStudent(Long id){
        return ResponseEntity.ok(StudentReqRespFactory.simpleStudentResponse(service.getStudent(id)));
    }


}
