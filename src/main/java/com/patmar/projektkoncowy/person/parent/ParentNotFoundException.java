package com.patmar.projektkoncowy.person.parent;

public class ParentNotFoundException extends RuntimeException {
    public ParentNotFoundException() {
        super("Requested Parent not found!");
    }
}
