package com.mercahub.config;

import com.mercahub.adapters.in.web.dto.ErrorResponseDto;
import com.mercahub.adapters.in.web.errors.InternalServerException;
import com.mercahub.adapters.in.web.errors.ItemNotFoundException;

import java.util.Collections;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ItemNotFoundException.class)
  public ResponseEntity<ErrorResponseDto> handleNotFound(ItemNotFoundException ex) {
    ErrorResponseDto error = new ErrorResponseDto();
    error.setMessage(ex.getMessage());
    error.setError("not_found");
    error.setStatus(404);
    error.setCause(Collections.emptyList());
            
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(InternalServerException.class)
  public ResponseEntity<ErrorResponseDto> handleInternalServer(InternalServerException ex) {
    ErrorResponseDto error = new ErrorResponseDto();
    error.setMessage(ex.getMessage());
    error.setError("internal_error");
    error.setStatus(500);
    error.setCause(Collections.emptyList());
    
    return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
