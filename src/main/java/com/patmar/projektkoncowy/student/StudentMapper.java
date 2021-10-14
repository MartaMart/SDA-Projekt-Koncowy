package com.patmar.projektkoncowy.student;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
interface StudentMapper {

    StudentMapper MAPPER = getMapper(StudentMapper.class);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "schoolClass", ignore = true)
    })

    Student toStudent(StudentCreateRequest request);

    StudentView toStudentListView(Student student);

    StudentView toStudentSingleView(Student student);
}
