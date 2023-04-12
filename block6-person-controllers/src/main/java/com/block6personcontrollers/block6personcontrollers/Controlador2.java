package com.block6personcontrollers.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping(value = "/controlador2")
public class Controlador2 {
    @Autowired
    CollectionBeans collectionBeans;

    @GetMapping(value = "/getPersona")
    public Persona getPersona(){
        collectionBeans.getPersona().setEdad(collectionBeans.getPersona().getEdad()*2);
        return collectionBeans.getPersona();
    }


    @GetMapping(value = "/getCiudades")
    public ArrayList<Ciudad> getCiudades(){
        return collectionBeans.getCiudades();
    }
}
