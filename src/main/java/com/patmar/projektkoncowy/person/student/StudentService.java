package com.patmar.projektkoncowy.person.student;

import com.patmar.projektkoncowy.person.PersonData;
import com.patmar.projektkoncowy.person.parent.Parent;
import com.patmar.projektkoncowy.person.parent.ParentDto;
import com.patmar.projektkoncowy.person.parent.ParentService;
import com.patmar.projektkoncowy.studentClass.StudentClass;
import com.patmar.projektkoncowy.studentClass.StudentClassDto;
import com.patmar.projektkoncowy.studentClass.StudentClassService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor

public class StudentService {

    private final StudentRepository repository;
    private final StudentClassService studentClassService;
    private final ParentService parentService;

    @Transactional
    public void updateStudent(StudentDto studentDto) {
//todo
        
    }

    public void deleteStudent(Long id) {
        repository.delete(id);
    }

    @Transactional
    public void createStudent(StudentDto studentDto) {
        Student student = Student.builder()
                .personData(PersonData.builder()
                        .name(studentDto.getName())
                        .surname(studentDto.getSurname())
                        .email(studentDto.getEmail())
                        .phoneNumber(studentDto.getPhoneNumber())
                        .build())
                .pesel(studentDto.getPesel())
                .studentClass(Optional.ofNullable(studentDto.getStudentClassDto().getId())
                        .map(studentClassService::getStudentClassById)
                        .orElse(internCreateStudentClass(studentDto.getStudentClassDto())))
                .parent(Optional.ofNullable(studentDto.getParentDto().getId())
                        .map(parentService::getParentById)
                        .orElse(internCreateParent((studentDto.getParentDto()))))
                .build();

        log.info("Try create student [{}] ", student);

        repository.save(student);

        log.info("Create user succeed");

    }

    private Parent internCreateParent(ParentDto parentDto) {
        return Parent.builder().personData(PersonData.builder()
                .name(parentDto.getName())
                .surname(parentDto.getSurname())
                .phoneNumber(parentDto.getPhoneNumber())
                .email(parentDto.getEmail()).build())
                .build();
    }

    private StudentClass internCreateStudentClass(StudentClassDto studentClassDto) {
        return StudentClass.builder()
                .classSymbol(studentClassDto.getClassSymbol())
                .schoolYearBook(studentClassDto.getSchoolYearBook())
                .year(studentClassDto.getYear())
                .build();
    }

    public List<StudentDto> getAllStudents() {
        return repository.findAll().stream().map(StudentDto::toDto).collect(Collectors.toList());
    }

    public StudentDto getStudent(Long id) {
        return StudentDto.toDto(repository.findById(id).orElseThrow(StudentNotFoundException::new));
    }
}
