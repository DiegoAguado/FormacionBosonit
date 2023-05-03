package com.block7crudvalidation.block7crudvalidation.exception.domain;

import com.block7crudvalidation.block7crudvalidation.exception.controller.dto.CustomErrorOutputDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<CustomErrorOutputDto> handleEntityNotFoundException(EntityNotFoundException e){
        CustomError customError = new CustomError();
        customError.setHttpCode(HttpStatus.NOT_FOUND.value());
        customError.setMensaje(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customError.customErrorToCustomErrorOutputDto());
    }

    @ExceptionHandler(UnprocessableEntityException.class)
    public ResponseEntity<CustomErrorOutputDto> handleUnprocessableEntityException(UnprocessableEntityException e){
        CustomError customError = new CustomError();
        customError.setHttpCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
        customError.setMensaje(e.getMessage());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(customError.customErrorToCustomErrorOutputDto());
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<CustomErrorOutputDto> handleJdbcSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e){
        CustomError customError = new CustomError();
        customError.setHttpCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        customError.setMensaje(e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(customError.customErrorToCustomErrorOutputDto());
    }
}
