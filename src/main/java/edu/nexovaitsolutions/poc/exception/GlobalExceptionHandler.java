package edu.nexovaitsolutions.poc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    Handle all errors validated by spring validation
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleInvalidFormat(HttpMessageNotReadableException ex) {
        String message = "Invalid input format";

        if (ex.getCause() instanceof com.fasterxml.jackson.databind.exc.InvalidFormatException invalidEx) {
            String fieldName = invalidEx.getPath().get(0).getFieldName();
            message = fieldName + " must be a number";
        }

        ErrorResponse response = new ErrorResponse();
        response.setMessage(message);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
