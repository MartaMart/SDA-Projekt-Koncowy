package com.patmar.projektkoncowy.person;


import com.patmar.projektkoncowy.commons.EntityBase;
import lombok.*;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
public class PersonData extends EntityBase {

    private String name;

    private String surname;

    private String email;

    private String phoneNumber;

}
