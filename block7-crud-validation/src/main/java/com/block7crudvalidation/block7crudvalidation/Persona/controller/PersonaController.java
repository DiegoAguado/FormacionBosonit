package com.block7crudvalidation.block7crudvalidation.Persona.controller;

import com.block7crudvalidation.block7crudvalidation.Feign.MyFeign;
import com.block7crudvalidation.block7crudvalidation.Persona.application.PersonaService;
import com.block7crudvalidation.block7crudvalidation.Profesor.controller.dto.ProfesorOutputDto;
import com.block7crudvalidation.block7crudvalidation.exception.domain.EntityNotFoundException;
import com.block7crudvalidation.block7crudvalidation.exception.domain.UnprocessableEntityException;
import com.block7crudvalidation.block7crudvalidation.Persona.controller.dto.PersonaInputDto;
import com.block7crudvalidation.block7crudvalidation.Persona.controller.dto.PersonaOutputDto;
import feign.Feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    PersonaService personaService;

    @PostMapping
    public ResponseEntity<PersonaOutputDto> addPersona(@RequestBody PersonaInputDto personaInputDto) throws UnprocessableEntityException {
        URI location = URI.create("/persona");
        try {
            return ResponseEntity.created(location).body(personaService.addPersona(personaService.validacion(personaInputDto)));
        } catch (UnprocessableEntityException e) {
            throw new UnprocessableEntityException(e.getMessage());
        }
    }

    @GetMapping("/{id_Persona}")
    public ResponseEntity getPersonaById_Persona(@PathVariable int id_Persona, @RequestParam(defaultValue = "simple") String outputType) throws EntityNotFoundException {
        try {
            if (outputType.equalsIgnoreCase("full"))
                return ResponseEntity.ok().body(personaService.getDetalles(id_Persona));
            return ResponseEntity.ok().body(personaService.getPersonaById_Persona(id_Persona));
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    @GetMapping("/usuario/{usuario}")
    public ResponseEntity<List> getPersonasByUsuario(@PathVariable String usuario, @RequestParam(defaultValue = "simple") String outputType) throws EntityNotFoundException {
        try {
            if (outputType.equalsIgnoreCase("full")) {
                List<Object> personaList = new ArrayList<>();
                for (PersonaOutputDto personaOutputDto : personaService.getPersonaByUsuario(usuario)) {
                    personaList.add(personaService.getDetalles(personaOutputDto.getId_persona()));
                }
                return ResponseEntity.ok().body(personaList);
            }
            return ResponseEntity.ok().body(personaService.getPersonaByUsuario(usuario));
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List> getPersonas(@RequestParam(defaultValue = "simple") String outputType) throws EntityNotFoundException {
        if (outputType.equalsIgnoreCase("full")) {
            List<Object> personaList = new ArrayList<>();
            for (PersonaOutputDto personaOutputDto : personaService.getPersonas()) {
                try {
                    personaList.add(personaService.getDetalles(personaOutputDto.getId_persona()));
                } catch (EntityNotFoundException e) {
                    throw new EntityNotFoundException(e.getMessage());
                }
            }
            return ResponseEntity.ok().body(personaList);
        }
        return ResponseEntity.ok().body(personaService.getPersonas());
    }

    @DeleteMapping("/{id_Persona}")
    public ResponseEntity<PersonaOutputDto> deletePersonaById(@PathVariable int id_Persona) throws EntityNotFoundException {
        try {
            PersonaOutputDto personaOutputDto = personaService.getPersonaById_Persona(id_Persona);
            personaService.deleteById_Persona(id_Persona);
            return ResponseEntity.ok().body(personaOutputDto);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    @PutMapping("/{id_Persona}")
    public ResponseEntity<PersonaOutputDto> updatePersona(@PathVariable int id_Persona, @RequestBody PersonaInputDto personaInputDto) throws EntityNotFoundException, UnprocessableEntityException {
        try {
            return ResponseEntity.ok().body(personaService.updatePersonaById_Persona(id_Persona, personaService.validacion(personaInputDto)));
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException(e.getMessage());
        } catch (UnprocessableEntityException e) {
            throw new UnprocessableEntityException(e.getMessage());
        }
    }

    /*@GetMapping("/profesor/{id}")
    public ResponseEntity<ProfesorOutputDto> getProfesor(@PathVariable int id) throws EntityNotFoundException {
        ProfesorOutputDto profesorOutputDto = new RestTemplate().getForObject("http://localhost:8080/profesor/"+id, ProfesorOutputDto.class);
        return ResponseEntity.ok().body(profesorOutputDto);
    }*/

    @GetMapping("/profesor/{id_Profesor}")
    public ResponseEntity<String> getProfesorFeign(@PathVariable int id_Profesor) throws EntityNotFoundException {
        MyFeign myFeign = Feign.builder().target(MyFeign.class, "http://localhost:8081/profesor/"+id_Profesor);
        return ResponseEntity.ok().body(myFeign.getProfesor());
    }
}
