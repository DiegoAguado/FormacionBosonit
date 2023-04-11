package com.block6simplecontrollers.block6simplecontrollers;

import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class Persona {
    private String nombre;
    private String poblacion;
    private int edad;
}
