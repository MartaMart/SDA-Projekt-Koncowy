package com.patmar.projektkoncowy.teacher;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, nullValuePropertyMappingStrategy =
        NullValuePropertyMappingStrategy.IGNORE)
public interface TeacherMapper {

    TeacherMapper MAPPER = Mappers.getMapper(TeacherMapper.class);

//    @Mapping(source = "name", target = "name")
//    @Mapping(source = "surname", target = "surname")
//    @Mapping(source = "phoneNumber", target = "phoneNumber")
//    @Mapping(source = "email", target = "email")
//    @Mapping(target = "role", constant = "ROLE_TEACHER")
//    Teacher teacherRequestBodyToTeacher(TeacherRequestBody body);

//    TeacherView teacherToTeacherView(Teacher teacher);

    TeacherPersonalDataView teacherToPersonalDetailView(Teacher teacher);

}
