package com.example.System.exception;

public class EntityNotFoundException extends Throwable {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
