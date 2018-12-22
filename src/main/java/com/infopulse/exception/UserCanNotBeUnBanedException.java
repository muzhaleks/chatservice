package com.infopulse.exception;

public class UserCanNotBeUnBanedException extends RuntimeException {
    public UserCanNotBeUnBanedException(String message){
        super(message);
    }
}
