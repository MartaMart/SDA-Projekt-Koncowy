package com.patmar.projektkoncowy.schoolclass;

public class GradeLevelAlreadyExistsException extends RuntimeException {
    public GradeLevelAlreadyExistsException(String message) {
        super("Class with name: "+ message+" already exists.");
    }
}
