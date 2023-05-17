package com.formacionBack.block10dockerizeapp.controller;


import com.formacionBack.block10dockerizeapp.application.PersonaServiceImpl;
import com.formacionBack.block10dockerizeapp.controller.dto.PersonaInputDto;
import com.formacionBack.block10dockerizeapp.controller.dto.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class ControllerUpdate {
    @Autowired
    PersonaServiceImpl personaService;
    @PutMapping("/{id}")
    public ResponseEntity<PersonaOutputDto> updatePersona(@PathVariable String id, @RequestBody PersonaInputDto personaInputDto){
        try{
            return ResponseEntity.ok().body(personaService.updatePersona(id, personaInputDto));
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
