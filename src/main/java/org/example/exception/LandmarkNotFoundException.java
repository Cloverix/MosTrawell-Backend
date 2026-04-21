package org.example.exception;

public class LandmarkNotFoundException extends RuntimeException {
    public LandmarkNotFoundException(String message) {
        super(message);
    }
}
