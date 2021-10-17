package com.patmar.projektkoncowy.teacher;

import com.patmar.projektkoncowy.schoolclass.SchoolClass;
import com.patmar.projektkoncowy.schoolclass.SchoolClassMapper;
import com.patmar.projektkoncowy.schoolclass.SchoolClassService;
import com.patmar.projektkoncowy.schoolclass.SchoolClassViewIdAndGrade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final SchoolClassService classService;

    public void create(TeacherRequestBody request) {
        Long classId = request.getClassId();
        SchoolClass classById = classService.findClassById(classId);
        Teacher teacher = TeacherMapper.MAPPER.teacherRequestBodyToTeacher(request);
        classById.setTeacher(teacher);
        teacher.setSchoolClass(classById);
        teacherRepository.save(teacher);
        log.info("New teacher has been created");
    }

    public List<TeacherView> displayAll() {
        List<Teacher> allTeachers = teacherRepository.findAll();
        if (allTeachers.isEmpty()) {
            log.info("Teachers' list is empty.");
            return Collections.emptyList();
        }
        List<TeacherView> teacherViews =
                allTeachers.stream().map(TeacherMapper.MAPPER::teacherToTeacherView).collect(Collectors.toList());
        return teacherViews;
    }

    public TeacherView displayById(Long id) {
        Teacher teacherById = findTeacherById(id);
        TeacherView teacherView = TeacherMapper.MAPPER.teacherToTeacherView(teacherById);
        log.info("The Teacher with id: " + id + " has been displayed.");
        return teacherView;
    }

    public void removeById(Long id) {
        findTeacherById(id);
        teacherRepository.deleteById(id);
        log.info("Teacher with id: " + id + " has been updated.");
    }

    @Transactional
    public void updateById(Long id, TeacherRequestBody body) {
        Teacher teacherToUpdate = findTeacherById(id);
        teacherToUpdate.setName(body.getName());
        teacherToUpdate.setSurname(body.getSurname());
        teacherToUpdate.setEmail(body.getEmail());
        teacherToUpdate.setPhoneNumber(body.getPhoneNumber());
        SchoolClass classById = classService.findClassById(body.getClassId());
        teacherToUpdate.setSchoolClass(classById);
    }

    public SchoolClassViewIdAndGrade displayClassForTeacherWithGivenId(Long id) {
        SchoolClass schoolClass = findTeacherById(id).getSchoolClass();
        SchoolClassViewIdAndGrade schoolClassViewIdAndGrade = SchoolClassMapper.MAPPER.mapToIdAndGrade(schoolClass);
        log.info("Teacher with id: " + id + " is assign to class: " + schoolClassViewIdAndGrade.getGradeLevel() + ".");
        return schoolClassViewIdAndGrade;
    }

    public Teacher findTeacherById(Long id) {
        return teacherRepository.findById(id).orElseThrow(() -> new TeacherNotFoundException("Teacher with id: " + id + " does not exist."));
    }
}