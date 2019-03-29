package com.eileen.logic;

public class UserInvalidException extends RuntimeException {
    public UserInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserInvalidException(String message) {
        super(message);
    }
}
