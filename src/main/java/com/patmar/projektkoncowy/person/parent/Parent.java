package com.patmar.projektkoncowy.person.parent;

import com.patmar.projektkoncowy.commons.EntityBase;
import com.patmar.projektkoncowy.person.PersonData;
import com.patmar.projektkoncowy.person.student.Student;
import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "parents")
@Builder
public class Parent extends EntityBase {

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private PersonData personData;

    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
    private List<Student> students = new ArrayList<>();

    public Parent(String name, String surname, String email, String phoneNumber) {
        this.personData = PersonData.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .phoneNumber(phoneNumber).build();
    }

}
