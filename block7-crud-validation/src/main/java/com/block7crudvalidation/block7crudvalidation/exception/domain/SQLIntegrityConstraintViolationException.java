package com.block7crudvalidation.block7crudvalidation.exception.domain;

public class SQLIntegrityConstraintViolationException extends Exception{
    public SQLIntegrityConstraintViolationException() {
        super("ID duplicado");
    }

    public SQLIntegrityConstraintViolationException(String mensaje){
        super(mensaje);
    }
}
