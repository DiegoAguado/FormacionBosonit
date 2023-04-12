package com.block6personcontrollers.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/controlador")
public class Controlador {
    @Autowired
    @Qualifier("returnP1")
    Persona p1;
    @Autowired
    @Qualifier("returnP2")
    Persona p2;
    @Autowired
    @Qualifier("returnP3")
    Persona p3;
    @GetMapping(value = "/bean/{bean}")
    public Persona getBean(@PathVariable String bean){
        if(bean.equalsIgnoreCase(p1.getNombre())) return p1;
        if(bean.equalsIgnoreCase(p2.getNombre())) return p2;
        if(bean.equalsIgnoreCase(p3.getNombre())) return p3;
        else return null;
    }
}
