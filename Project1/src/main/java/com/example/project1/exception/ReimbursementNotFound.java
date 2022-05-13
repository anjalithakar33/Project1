package com.example.project1.exception;

public class ReimbursementNotFound extends RuntimeException {
    public ReimbursementNotFound(String message){
        super(message);
    }
}
