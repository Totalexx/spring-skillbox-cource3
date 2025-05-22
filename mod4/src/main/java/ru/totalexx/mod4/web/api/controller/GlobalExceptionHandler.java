package ru.totalexx.mod4.web.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.totalexx.mod4.exception.ServiceException;
import ru.totalexx.mod4.web.api.model.response.ExceptionResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ExceptionResponse> handleServiceException(ServiceException ex) {
        ExceptionResponse dto = new ExceptionResponse(ex.getMessage());
        return ResponseEntity.status(ex.getStatus()).body(dto);
    }

}
