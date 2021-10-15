package com.patmar.projektkoncowy.subject;

import lombok.Data;

@Data
public class SubjectNotFoundException {

    public SubjectNotFoundException (String message) {
        super(message);
    }
}
