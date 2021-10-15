package com.patmar.projektkoncowy.subject;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Data
@AllArgsConstructor
public class SubjectCreateRequest {

        @Size(min = 2, max = 20, message = "Subject name length should be between 0 and 20")
        @NotNull
        String subjectName;

    }

