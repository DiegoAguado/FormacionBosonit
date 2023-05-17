package com.formacionBack.block10dockerizeapp.controller;


import com.formacionBack.block10dockerizeapp.application.PersonaServiceImpl;
import com.formacionBack.block10dockerizeapp.controller.dto.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class ControllerDelete {
    @Autowired
    PersonaServiceImpl personaService;

    @DeleteMapping("/{id}")
    public ResponseEntity<PersonaOutputDto> deletePersonaById(@PathVariable String id){
        try{
            PersonaOutputDto personaOutputDto = personaService.getPersonaById(id);
            personaService.deletePersonaById(id);
            return ResponseEntity.ok().body(personaOutputDto);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
