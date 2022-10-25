package com.example.productservice.common.exception;

public class TechnicalException extends RuntimeException{
    public TechnicalException() { super(); }
    public TechnicalException(String message) { super(message); }
}
