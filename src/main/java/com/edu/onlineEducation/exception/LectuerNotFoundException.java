package com.edu.onlineEducation.exception;

public class LectuerNotFoundException extends RuntimeException{

    public LectuerNotFoundException() {
        super();
    }

    public LectuerNotFoundException(String message) {
        super(message);
    }

    public LectuerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
