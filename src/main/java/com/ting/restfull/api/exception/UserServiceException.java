package com.ting.restfull.api.exception;

public class UserServiceException extends RuntimeException{

    public UserServiceException(String message) {
        super(message);
    }
}
