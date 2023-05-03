package com.block7crudvalidation.block7crudvalidation.Profesor.controller;

import com.block7crudvalidation.block7crudvalidation.Profesor.application.ProfesorService;
import com.block7crudvalidation.block7crudvalidation.Profesor.controller.dto.ProfesorInputDto;
import com.block7crudvalidation.block7crudvalidation.Profesor.controller.dto.ProfesorOutputDto;
import com.block7crudvalidation.block7crudvalidation.exception.domain.EntityNotFoundException;
import com.block7crudvalidation.block7crudvalidation.exception.domain.SQLIntegrityConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {
    @Autowired
    ProfesorService profesorService;

    @PostMapping
    public ResponseEntity<ProfesorOutputDto> addProfesor(@RequestBody ProfesorInputDto profesorInputDto) throws EntityNotFoundException, SQLIntegrityConstraintViolationException {
        try {
            URI location = URI.create("/profesor");
            return ResponseEntity.created(location).body(profesorService.addProfesor(profesorInputDto));
        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException(e.getMessage());
        }catch (SQLIntegrityConstraintViolationException e){
            throw new SQLIntegrityConstraintViolationException(e.getMessage());
        }
    }

    @GetMapping("/{id_Profesor}")
    public ResponseEntity getProfesor(@PathVariable int id_Profesor, @RequestParam (defaultValue = "simple") String outputType) throws EntityNotFoundException {
        try{
            if(outputType.equals("full")) return ResponseEntity.ok().body(profesorService.getProfesorFull(id_Profesor));
            else return ResponseEntity.ok().body(profesorService.getProfesorSimple(id_Profesor));
        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<ProfesorOutputDto>> getProfesores(){
        return ResponseEntity.ok().body(profesorService.getProfesores());
    }

    @DeleteMapping("/{id_Profesor}")
    public ResponseEntity<ProfesorOutputDto> deleteProfesorById(@PathVariable int id_Profesor) throws EntityNotFoundException{
        try{
            profesorService.deleteById_Profesor(id_Profesor);
            return ResponseEntity.ok().build();
        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    @PutMapping("/{id_Profesor}")
    public ResponseEntity<ProfesorOutputDto> updateProfesor(@PathVariable int id_Profesor, @RequestBody ProfesorInputDto profesorInputDto) throws EntityNotFoundException{
        try {
            return ResponseEntity.ok().body(profesorService.updateProfesorById(id_Profesor, profesorInputDto));
        }catch (EntityNotFoundException e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }
}
