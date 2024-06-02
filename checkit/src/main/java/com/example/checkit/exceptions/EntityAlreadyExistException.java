package com.example.checkit.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public class EntityAlreadyExistException extends RuntimeException{

    private HttpStatus status;

    private String message;
    public EntityAlreadyExistException(String message, HttpStatus status){
        super(message);
        this.message = message;
        this.status = status;
    }
}
