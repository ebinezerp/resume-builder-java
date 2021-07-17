package org.example.resumebuilder.exception;

public class InvalidJsonFormatException extends Exception {

    private String message;
    public InvalidJsonFormatException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
