package com.example.exception;

public class CustomerServiceException extends RuntimeException {
    public CustomerServiceException(String s) {
        super(s);
    }
}
