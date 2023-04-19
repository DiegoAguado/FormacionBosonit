package com.block7crudvalidation.block7crudvalidation.controller;

import com.block7crudvalidation.block7crudvalidation.application.PersonaServiceImpl;
import com.block7crudvalidation.block7crudvalidation.controller.dto.PersonaInputDto;
import com.block7crudvalidation.block7crudvalidation.controller.dto.PersonaOutputDto;
import com.block7crudvalidation.block7crudvalidation.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class Controller {
    @Autowired
    PersonaServiceImpl personaService;

    @PostMapping
    public ResponseEntity<PersonaOutputDto> addPersona(@RequestBody PersonaInputDto personaInputDto){
        URI location = URI.create("/persona");
        return ResponseEntity.created(location).body(personaService.addPersona(personaInputDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaOutputDto> getPersonaById(@PathVariable int id){
        return ResponseEntity.ok().body(personaService.findById(id));
    }

    @GetMapping("/usuario/{usuario}")
    public List<Persona> getPersonasById(@PathVariable String usuario){
        return personaService.findByUsuario(usuario);
    }

    @GetMapping
    public List<Persona> getPersonas(){
        return personaService.getPersonas();
    }
}
