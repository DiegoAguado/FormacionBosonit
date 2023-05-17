package com.formacionBack.block10dockerizeapp.controller;


import com.formacionBack.block10dockerizeapp.application.PersonaServiceImpl;
import com.formacionBack.block10dockerizeapp.controller.dto.PersonaOutputDto;
import com.formacionBack.block10dockerizeapp.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class ControllerConsultar {
    @Autowired
    PersonaServiceImpl personaService;

    @GetMapping("/{id}")
    public ResponseEntity<PersonaOutputDto> getPersonaById(@PathVariable String id){
        try{
            return ResponseEntity.ok().body(personaService.getPersonaById(id));
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/nombre/{nombre}")
    public List<Persona> getPersonasByNombre(@PathVariable String nombre){
        return personaService.getPersonasByNombre(nombre);
    }

    @GetMapping
    public List<Persona> getPersonas(){
        return personaService.getPersonas();
    }
}
