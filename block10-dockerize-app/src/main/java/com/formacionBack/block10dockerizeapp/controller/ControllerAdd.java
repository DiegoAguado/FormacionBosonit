package com.formacionBack.block10dockerizeapp.controller;

import com.formacionBack.block10dockerizeapp.application.PersonaServiceImpl;
import com.formacionBack.block10dockerizeapp.controller.dto.PersonaInputDto;
import com.formacionBack.block10dockerizeapp.controller.dto.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/persona")
public class ControllerAdd {
    @Autowired
    PersonaServiceImpl personaService;

    @PostMapping
    public ResponseEntity<PersonaOutputDto> addPersona(@RequestBody PersonaInputDto personaInputDto){
        URI location = URI.create("/persona");
        return ResponseEntity.created(location).body(personaService.addPersona(personaInputDto));
    }
}
