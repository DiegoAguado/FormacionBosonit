package com.block7crudvalidation.block7crudvalidation.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class EntityNotFoundException extends Exception {
    public EntityNotFoundException() {
        super("ID NO ENCONTRADO");
    }

    public EntityNotFoundException(String mensaje){
        super(mensaje);
    }
}
