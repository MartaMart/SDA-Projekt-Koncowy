package com.patmar.projektkoncowy.schoolclass;

import com.patmar.projektkoncowy.student.Student;
import com.patmar.projektkoncowy.subject.Subject;
import com.patmar.projektkoncowy.teacher.Teacher;
import com.patmar.projektkoncowy.teacher.TeacherMapper;
import com.patmar.projektkoncowy.teacher.TeacherPersonalDataView;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SchoolClassService {

    private final SchoolClassRepository repository;

    public void create(SchoolClassRequestBody body) {
        SchoolClass schoolClass = SchoolClassMapper.MAPPER.mapToSchoolClass(body);
        repository.save(schoolClass);
        log.info("The class has been created");
    }

    public List<SchoolClassView> displayAll() {
        List<SchoolClass> all = repository.findAll();
        if (all.isEmpty()) {
            log.info("School Classes list is empty.");
            return Collections.emptyList();
        }
        List<SchoolClassView> views =
                all.stream().map(SchoolClassMapper.MAPPER::mapToView).collect(Collectors.toList());
        return views;
    }

    public SchoolClassView displayById(Long id) {
        SchoolClass schoolClass = repository.findById(id).orElseThrow(null);
        SchoolClassView classToDisplay = SchoolClassMapper.MAPPER.mapToView(schoolClass);
        log.info("The Class with id: " + id + " has been displayed");
        return classToDisplay;
    }

    @Transactional
    public void delete(Long id) {
        Teacher teacher = findClassById(id).getTeacher();
        //info: 'try..catch' block is used to avoid NullPointerException- when we want to delete class
        //which doesn't have assign any teacher
        try {
            //info: 'setSchoolClass()' is used to avoid any integrity constraints errors
            // (DataIntegrityViolationException) and
            // avoiding deleting teacher automatically when the class is removed
            teacher.setSchoolClass(null);
            repository.deleteById(id);
            log.info("The class has been created");
        } catch (NullPointerException e) {
            repository.deleteById(id);
            log.info("The class has been created");
        }
    }

    @Transactional
    public void update(Long id, SchoolClassRequestBody body) {
        SchoolClass schoolClassToUpdate = repository.getById(id);
        SchoolClass schoolClass = SchoolClassMapper.MAPPER.mapToSchoolClass(body);
        schoolClassToUpdate.setGradeLevel(schoolClass.getGradeLevel());
        log.info("The class has been created");
    }

    public SchoolClass findClassById(Long classId) {
        //todo exception change, task:SDA-28
        return repository.findById(classId).orElseThrow(null);
    }

    public List<Student> displayStudentsByClassId(Long id) {
        List<Student> studentsToDisplay = findClassById(id).getStudents();
        //info: 'studentToSort' list is created to avoid java.lang.UnsupportedOperationException
        List<Student> studentsToSort = new ArrayList<>(studentsToDisplay);
        Comparator<Student> compareByName = (Student s1, Student s2) -> s1.getName().compareToIgnoreCase(s2.getName());
        Comparator<Student> compareBySurname =
                (Student s1, Student s2) -> s1.getSurname().compareToIgnoreCase(s2.getSurname());
        studentsToSort.sort(compareBySurname.thenComparing(compareByName));
        log.info("Students who belong to class with id: " + id + " have been displayed.");
        return studentsToSort;
    }

    public List<Subject> displaySubjectsByClassId(Long id) {
        List<Subject> subjectsToDisplay = findClassById(id).getSubjects();
        List<Subject> subjectsToSort = new ArrayList<>(subjectsToDisplay);
        Comparator<Subject> compareBySubjectName =
                (Subject s1, Subject s2) -> s1.getSubjectName().compareToIgnoreCase(s2.getSubjectName());
        subjectsToSort.sort(compareBySubjectName);
        log.info("Subjects who belong to class with id: " + id + " have been displayed.");
        return subjectsToDisplay;
    }

    public TeacherPersonalDataView displayTeacherForGivenClass(Long id) {
        TeacherPersonalDataView teacherPersonalDataView =
                TeacherMapper.MAPPER.teacherToPersonalDetailView(findClassById(id).getTeacher());
        log.info("In class: " + id + ", teacher with id: " + teacherPersonalDataView.getId() + " works.");
        return teacherPersonalDataView;
    }
}