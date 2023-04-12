package com.block6personcontrollers.block6personcontrollers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;


@RestController
@RequestMapping(value = "/controlador1")
public class Controlador1 {
    @Autowired
    CollectionBeans collectionBeans;

    @GetMapping(value = "/addPersona")
    public Persona addPersona(@RequestHeader Map<String, String> headers){
        collectionBeans.getPersona().setNombre(headers.get("nombre"));
        collectionBeans.getPersona().setPoblacion(headers.get("poblacion"));
        collectionBeans.getPersona().setEdad(Integer.parseInt(headers.get("edad")==null?"0":headers.get("edad")));
        return collectionBeans.getPersona();
    }

    @PostMapping(value = "/addCiudad")
    public ArrayList<Ciudad> addCiudad(@RequestBody Map<String, String> ciudad){
        collectionBeans.getCiudades().add(new Ciudad(ciudad.get("nombre"), Integer.parseInt(ciudad.get("numeroHabitantes")==null?"0":ciudad.get("numeroHabitantes"))));
        return collectionBeans.getCiudades();
    }
}
