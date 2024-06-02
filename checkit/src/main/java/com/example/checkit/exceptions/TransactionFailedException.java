package com.example.checkit.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public class TransactionFailedException extends RuntimeException{

    private String message;

    private HttpStatus status;

    public TransactionFailedException(String message, HttpStatus status){
        super(message);
        this.message = message;
        this.status = status;
    }
}
