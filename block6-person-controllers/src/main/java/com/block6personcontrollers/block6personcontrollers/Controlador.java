package com.block6personcontrollers.block6personcontrollers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/controlador")
public class Controlador {
    @Qualifier("returnP1")
    Persona p1;
    @Qualifier("returnP2")
    Persona p2;
    @Qualifier("returnP3")
    Persona p3;
    @GetMapping(value = "/bean/{bean}")
    public Persona getBean(@PathVariable String bean){
        System.out.println(p1.toString());
        return null;
    }
}
