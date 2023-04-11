package com.block6personcontrollers.block6personcontrollers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Controller
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    private String nombre;
    private String poblacion;
    private int edad;
}
