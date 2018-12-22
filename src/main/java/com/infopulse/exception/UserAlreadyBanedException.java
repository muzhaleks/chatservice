package com.infopulse.exception;

public class UserAlreadyBanedException extends RuntimeException {
    public UserAlreadyBanedException(String message){
        super(message);
    }
}
