package com.patmar.projektkoncowy.subject;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public interface SubjectMapper {

   SubjectMapper MAPPER = getMapper(SubjectMapper.class);
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "schoolClass", ignore = true)
    })
    Subject toSubject(SubjectCreateRequest request);

    SubjectView toSubjectListView(Subject subject);

   SubjectView toSubjectSingleView(Subject subject);
}
