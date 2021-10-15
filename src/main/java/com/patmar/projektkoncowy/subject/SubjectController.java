package com.patmar.projektkoncowy.subject;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/api/subjects")
public class SubjectController {

        private SubjectService service;

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public void addSubject ( @RequestBody @Valid SubjectCreateRequest request) {
            service.addSubject(request);
        }

        @GetMapping
        public List<SubjectView> findAll() {

            return service.findAll();
        }

        @GetMapping("/{id}")
        public List<SubjectView> getOne(@PathVariable Long id) {

            return service.getSubject(id);
        }

        @PutMapping
        void updateSubject (@RequestBody @Valid Subject subject) {

            service.updateSubject(subject);
        }

        @DeleteMapping
        void deleteSubject (Subject subject) {
            service.deleteSubject(subject);
        }
    }

