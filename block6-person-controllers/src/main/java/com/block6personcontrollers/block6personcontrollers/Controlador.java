package com.block6personcontrollers.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador {
    @Autowired
    @Qualifier("bean1")
    Persona bean1;

    @Autowired
    @Qualifier("bean2")
    Persona bean2;

    @Autowired
    @Qualifier("bean3")
    Persona bean3;
    @GetMapping(value = "/controlador/bean/{bean}")
    public Persona getBean(@PathVariable String bean){
        if(bean.equalsIgnoreCase(bean1.getNombre())) return bean1;
        if(bean.equalsIgnoreCase(bean2.getNombre())) return bean2;
        if(bean.equalsIgnoreCase(bean3.getNombre())) return bean3;
        else return null;
    }
}
