package com.example.checkit.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public class EntityNotFoundException extends RuntimeException {

    private String message;

    private HttpStatus status;

    public EntityNotFoundException(String message, HttpStatus status){
        super(message);
        this.message = message;
        this.status = status;
    }
}
