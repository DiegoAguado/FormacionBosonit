package com.block6personcontrollers.block6personcontrollers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;


@RestController
@RequestMapping(value = "/controlador1")
public class Controlador1 {
    @Autowired
    @Qualifier("returnPersona")
    Persona p;

    @Autowired
    @Qualifier("returnCiudades")
    ArrayList<Ciudad> ciudades;

    @Bean
    @GetMapping(value = "/addPersona")
    public Persona addPersona(@RequestHeader Map<String, String> headers){
        p.setNombre(headers.get("nombre"));
        p.setPoblacion(headers.get("poblacion"));
        p.setEdad(Integer.parseInt(headers.get("edad")==null?"0":headers.get("edad")));
        return p;
    }

    @Bean
    @PostMapping(value = "/addCiudad")
    public ArrayList<Ciudad> addCiudad(@RequestBody Map<String, String> ciudad){
        if(ciudades.size()==1 && ciudades.get(0).getNombre()==null && ciudades.get(0).getNumeroHabitantes()==0){
            ciudades.get(0).setNombre(ciudad.get("nombre"));
            ciudades.get(0).setNumeroHabitantes(Integer.parseInt(ciudad.get("numeroHabitantes")==null?"0":ciudad.get("numeroHabitantes")));
        }else ciudades.add(new Ciudad(ciudad.get("nombre"), Integer.parseInt(ciudad.get("numeroHabitantes")==null?"0":ciudad.get("numeroHabitantes"))));
        return ciudades;
    }
}
