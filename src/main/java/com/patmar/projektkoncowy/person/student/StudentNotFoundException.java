package com.patmar.projektkoncowy.person.student;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException() {
        super("Student not found!");
    }
}
