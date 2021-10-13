package com.patmar.projektkoncowy.schoolclass;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SchoolClassMapper {

    SchoolClassMapper MAPPER=Mappers.getMapper(SchoolClassMapper.class);

    SchoolClass mapToSchoolClass(SchoolClassRequestBody body);

    SchoolClassView mapToView(SchoolClass schoolClass);

    SchoolClassViewIdAndGrade mapToIdAndGrade(SchoolClass schoolClass);
}
