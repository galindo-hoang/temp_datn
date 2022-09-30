package com.example.UserService.exception;

public class BusinessException extends RuntimeException {
    public BusinessException() { super(); }
    public BusinessException(String message) { super(message);}
}
