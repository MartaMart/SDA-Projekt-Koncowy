package com.patmar.projektkoncowy.person.parent;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ParentDto {
    Long id;

    private final String name;

    private final String surname;

    private final String email;

    private final String phoneNumber;

    public static ParentDto toDto(Parent parent) {
        return ParentDto.builder()
                .id(parent.getId())
                .name(parent.getPersonData().getName())
                .surname(parent.getPersonData().getSurname())
                .email(parent.getPersonData().getEmail())
                .phoneNumber(parent.getPersonData().getPhoneNumber())
                .build();
    }
}
