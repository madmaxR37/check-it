package com.example.checkit.handlers;

import com.example.checkit.dtos.ValidationResponseDto;
import com.example.checkit.exceptions.EntityAlreadyExistException;
import com.example.checkit.exceptions.EntityNotFoundException;
import com.example.checkit.exceptions.TransactionFailedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationResponseDto> handleValidationException(MethodArgumentNotValidException exception){
        Map<String,String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error->
                errors.put(error.getField(),error.getDefaultMessage()));

        ValidationResponseDto errorResponse = new ValidationResponseDto(errors);

        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(EntityAlreadyExistException.class)
    public ResponseEntity<Object> handleEntityAlreadyExistException(EntityAlreadyExistException exception){
       return ResponseHandler.generateResponse(exception.getMessage(), exception.getStatus());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException exception){
        return ResponseHandler.generateResponse(exception.getMessage(),exception.getStatus());
    }

    @ExceptionHandler(TransactionFailedException.class)
    public ResponseEntity<Object> handleTransactionFailedException(TransactionFailedException exception){
        return ResponseHandler.generateResponse(exception.getMessage(),exception.getStatus());
    }
}
