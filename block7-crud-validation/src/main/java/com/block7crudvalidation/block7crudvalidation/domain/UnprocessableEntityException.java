package com.block7crudvalidation.block7crudvalidation.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UnprocessableEntityException extends Exception{
    public UnprocessableEntityException() {
        super("422(UNPROCESSABLE ENTITY)");
    }

    public UnprocessableEntityException(String mensaje){
        super(mensaje);
    }
}
