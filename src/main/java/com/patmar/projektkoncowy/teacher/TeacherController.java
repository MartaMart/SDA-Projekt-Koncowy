package com.patmar.projektkoncowy.teacher;

import com.patmar.projektkoncowy.schoolclass.SchoolClassViewIdAndGrade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/teachers")
@RequiredArgsConstructor
@Slf4j
class TeacherController {

    private final TeacherService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody TeacherRequestBody teacher){
        service.create(teacher);
        log.info("New teacher has been created");
    }

    @GetMapping
    public List<TeacherView> displayAll(){
        return service.displayAll();
    }

    @GetMapping("/{id}")
    public TeacherView displayById(@PathVariable Long id){
        return service.displayById(id);
    }

    @PutMapping("/{id}")
    public void updateById(@PathVariable Long id, @RequestBody TeacherRequestBody body){
        service.updateById(id,body);
        log.info("Teacher with id: "+id +" has been updated.");
    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable Long id){
        service.removeById(id);
        log.info("Teacher with id: "+id +" has been removed.");
    }

    @GetMapping("/class/teacher")
    SchoolClassViewIdAndGrade displayClassForTeacherWithGivenId(@RequestParam Long id){
        return service.displayClassForTeacherWithGivenId(id);
    }
}
