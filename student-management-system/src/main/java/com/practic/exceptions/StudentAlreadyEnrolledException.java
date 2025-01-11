package com.practic.exceptions;

public class StudentAlreadyEnrolledException extends RuntimeException{

    public StudentAlreadyEnrolledException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
