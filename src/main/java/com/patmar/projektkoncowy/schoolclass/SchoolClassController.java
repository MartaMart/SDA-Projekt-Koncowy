package com.patmar.projektkoncowy.schoolclass;

import com.patmar.projektkoncowy.student.Student;
import com.patmar.projektkoncowy.subject.Subject;
import com.patmar.projektkoncowy.teacher.TeacherPersonalDataView;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
@Slf4j
@RequiredArgsConstructor
class SchoolClassController {

    private final SchoolClassService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void create(@RequestBody SchoolClassRequestBody body) {
        service.create(body);
    }

    @GetMapping
    List<SchoolClassView> displayAll() {
        return service.displayAll();
    }

    @GetMapping("/{id}")
    SchoolClassView displayById(@PathVariable Long id) {
        return service.displayById(id);
    }

    @GetMapping("/students/class")
    List<Student> displayStudentsByClassId(@RequestParam Long id) {
        return service.displayStudentsByClassId(id);
    }

    @GetMapping("/subjects/class")
    List<Subject> displaySubjectsByClassId(@RequestParam Long id) {
        return service.displaySubjectsByClassId(id);
    }

    @GetMapping("/teacher/class")
    TeacherPersonalDataView displayTeacherForGivenClass(@RequestParam Long id) {
        return service.displayTeacherForGivenClass(id);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    void update(@PathVariable Long id, @RequestBody SchoolClassRequestBody body) {
        service.update(id, body);
    }
}