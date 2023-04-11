package com.block6personcontrollers.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping(value = "/controlador2")
public class Controlador2 {
    @Autowired
    @Qualifier("addPersona")
    Persona p;

    @Autowired
    @Qualifier("addCiudad")
    ArrayList<Ciudad> ciudades;

    @Bean
    @GetMapping(value = "/getPersona")
    public Persona getPersona(){
        p.setEdad(p.getEdad()*2);
        return p;
    }


    @GetMapping(value = "/getCiudades")
    public ArrayList<Ciudad> getCiudades(){
        return ciudades;
    }
}
