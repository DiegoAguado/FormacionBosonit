package com.block7crudvalidation.block7crudvalidation.controller;

import com.block7crudvalidation.block7crudvalidation.domain.CustomError;
import com.block7crudvalidation.block7crudvalidation.domain.EntityNotFoundException;
import com.block7crudvalidation.block7crudvalidation.domain.UnprocessableEntityException;
import com.block7crudvalidation.block7crudvalidation.application.PersonaServiceImpl;
import com.block7crudvalidation.block7crudvalidation.controller.dto.CustomErrorOutputDto;
import com.block7crudvalidation.block7crudvalidation.controller.dto.PersonaInputDto;
import com.block7crudvalidation.block7crudvalidation.controller.dto.PersonaOutputDto;
import com.block7crudvalidation.block7crudvalidation.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<PersonaOutputDto> addPersona(@RequestBody PersonaInputDto personaInputDto) throws UnprocessableEntityException{
        URI location = URI.create("/persona");
        try{
            return ResponseEntity.created(location).body(personaService.addPersona(personaService.validacion(personaInputDto)));
        }catch(UnprocessableEntityException e){
            throw new UnprocessableEntityException(e.getMessage());
        }
    }

    @GetMapping("/{id_Persona}")
    public ResponseEntity<PersonaOutputDto> getPersonaById_Persona(@PathVariable int id_Persona) throws EntityNotFoundException{
        try{
            return ResponseEntity.ok().body(personaService.getPersonaById_Persona(id_Persona));
        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    @GetMapping("/usuario/{usuario}")
    public List<Persona> getPersonasByUsuario(@PathVariable String usuario) throws EntityNotFoundException{
        try {
            return personaService.getPersonaByUsuario(usuario);
        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    @GetMapping
    public List<Persona> getPersonas(){
        return personaService.getPersonas();
    }

    @DeleteMapping("/{id_Persona}")
    public ResponseEntity<PersonaOutputDto> deletePersonaById(@PathVariable int id_Persona) throws EntityNotFoundException{
        try{
            PersonaOutputDto personaOutputDto = personaService.getPersonaById_Persona(id_Persona);
            personaService.deleteById_Persona(id_Persona);
            return ResponseEntity.ok().body(personaOutputDto);
        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    @PutMapping("/{id_Persona}")
    public ResponseEntity<PersonaOutputDto> updatePersona(@PathVariable int id_Persona, @RequestBody PersonaInputDto personaInputDto) throws EntityNotFoundException, UnprocessableEntityException{
        try {
            return ResponseEntity.ok().body(personaService.updatePersonaById_Persona(id_Persona, personaService.validacion(personaInputDto)));
        }catch (EntityNotFoundException e) {
            throw new EntityNotFoundException(e.getMessage());
        }catch (UnprocessableEntityException e){
            throw new UnprocessableEntityException(e.getMessage());
        }
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<CustomErrorOutputDto> handleEntityNotFoundException(EntityNotFoundException e){
        CustomError customError = new CustomError();
        customError.setHttpCode(HttpStatus.NOT_FOUND.value());
        customError.setMensaje(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customError.customErrorToCustomErrorOutputDto());
    }

    @ExceptionHandler(UnprocessableEntityException.class)
    public ResponseEntity<CustomErrorOutputDto> handleUnprocessableEntityException(UnprocessableEntityException e){
        CustomError customError = new CustomError();
        customError.setHttpCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
        customError.setMensaje(e.getMessage());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(customError.customErrorToCustomErrorOutputDto());
    }
}
