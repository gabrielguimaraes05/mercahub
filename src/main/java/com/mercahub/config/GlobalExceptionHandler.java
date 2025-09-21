package com.mercahub.config;

import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mercahub.adapters.in.web.errors.InternalServerException;
import com.mercahub.adapters.in.web.errors.ItemNotFoundException;
import com.mercahub.dto.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ItemNotFoundException ex) {
        ErrorResponse error = new ErrorResponse()
            .message(ex.getMessage())
            .error("not_found")
            .status(404)
            .cause(Collections.emptyList());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity<ErrorResponse> handleInternalServer(InternalServerException ex) {
        ErrorResponse error = new ErrorResponse()
            .message(ex.getMessage())
            .error("internal_error")
            .status(500)
            .cause(Collections.emptyList());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
