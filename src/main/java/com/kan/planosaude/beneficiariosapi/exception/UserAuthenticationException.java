package com.kan.planosaude.beneficiariosapi.exception;

public class UserAuthenticationException extends RuntimeException{
    public UserAuthenticationException(String message) {
        super(message);
    }
}