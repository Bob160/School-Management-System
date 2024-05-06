package com.bobrox.demo.exception;

public class TeacherAlreadyExistsException extends RuntimeException{

    public TeacherAlreadyExistsException(String message) {
        super(message);
    }
}
