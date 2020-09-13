package com.thoughtworks.capability.gtb.restfulapidesign.exception;

public class TeamNotExistException extends RuntimeException {
    public TeamNotExistException(String message) {
        super(message);
    }
}
