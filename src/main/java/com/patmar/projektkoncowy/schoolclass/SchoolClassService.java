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

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SchoolClassService {

    private final SchoolClassRepository repository;

    public void create(SchoolClassRequestBody body) {
        SchoolClass schoolClass = SchoolClassMapper.MAPPER.mapToSchoolClass(body);
        repository.save(schoolClass);
    }

    public List<SchoolClassView> displayAll() {
        List<SchoolClass> all = repository.findAll();
        if (all.size() == 0) {
            log.info("School Classes list is empty.");
            return null;
        }
        List<SchoolClassView> views =
                all.stream().map(SchoolClassMapper.MAPPER::mapToView).collect(Collectors.toList());
        log.info("All classes have been displayed.");
        return views;
    }

    public SchoolClassView displayById(Long id) {
        SchoolClass schoolClass = findClassById(id);
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
        } catch (NullPointerException e) {
            repository.deleteById(id);
        }
    }

    @Transactional
    public void update(Long id, SchoolClassRequestBody body) {
        SchoolClass schoolClassToUpdate = findClassById(id);
        SchoolClass schoolClass = SchoolClassMapper.MAPPER.mapToSchoolClass(body);
        schoolClassToUpdate.setGradeLevel(schoolClass.getGradeLevel());
    }

    public SchoolClass findClassById(Long classId) {
        return repository.findById(classId).orElseThrow(() -> new SchoolClassNotFoundException("The class with id: " + classId + " does not exist."));
    }

    public Set<Student> displayStudentsByClassId(Long id) {
        Set<Student> studentsToDisplay = findClassById(id).getStudents();
        log.info("Students who belong to class with id: " + id + " have been displayed.");
        return studentsToDisplay;
    }

    public Set<Subject> displaySubjectsByClassId(Long id) {
        Set<Subject> subjectsToDisplay = findClassById(id).getSubjects();
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
