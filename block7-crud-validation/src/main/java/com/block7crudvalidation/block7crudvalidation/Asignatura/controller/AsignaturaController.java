package com.block7crudvalidation.block7crudvalidation.Asignatura.controller;

import com.block7crudvalidation.block7crudvalidation.Asignatura.controller.dto.AsignaturaInputDto;
import com.block7crudvalidation.block7crudvalidation.Asignatura.controller.dto.AsignaturaOutputDto;
import com.block7crudvalidation.block7crudvalidation.Estudiante.application.EstudianteService;
import com.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto.EstudianteInputDto;
import com.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto.EstudianteOutputDto;
import com.block7crudvalidation.block7crudvalidation.Asignatura.application.AsignaturaService;
import com.block7crudvalidation.block7crudvalidation.exception.controller.dto.CustomErrorOutputDto;
import com.block7crudvalidation.block7crudvalidation.exception.domain.CustomError;
import com.block7crudvalidation.block7crudvalidation.exception.domain.EntityNotFoundException;
import com.block7crudvalidation.block7crudvalidation.exception.domain.SQLIntegrityConstraintViolationException;
import com.block7crudvalidation.block7crudvalidation.exception.domain.UnprocessableEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/asignatura")
public class AsignaturaController {
    @Autowired
    AsignaturaService asignaturaService;

    @PostMapping
    public ResponseEntity<AsignaturaOutputDto> addAsignatura(@RequestBody AsignaturaInputDto asignaturaInputDto) throws EntityNotFoundException {
        try {
            URI location = URI.create("/asignatura");
            return ResponseEntity.created(location).body(asignaturaService.addAsignatura(asignaturaInputDto));
        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException(e.getMessage());
        }
    }



    @GetMapping("/{id_Estudiante}")
    public ResponseEntity<List<AsignaturaOutputDto>> getAsignatura(@PathVariable int id_Estudiante) {
            return ResponseEntity.ok().body(asignaturaService.getAsignaturasByEstudiante(id_Estudiante));
    }

    @GetMapping
    public ResponseEntity<List<AsignaturaOutputDto>> getAsignaturas(){
        return ResponseEntity.ok().body(asignaturaService.getAsignaturas());
    }

    @DeleteMapping("/{id_Asignatura}")
    public ResponseEntity deleteAsignaturaById(@PathVariable int id_Asignatura) throws EntityNotFoundException{
        try{
            asignaturaService.deleteById_Asignatura(id_Asignatura);
            return ResponseEntity.ok().build();
        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    @PutMapping("/{id_Asignatura}")
    public ResponseEntity<AsignaturaOutputDto> updateAsignatura(@PathVariable int id_Asignatura, @RequestBody AsignaturaInputDto asignaturaInputDto) throws EntityNotFoundException{
        try {
            return ResponseEntity.ok().body(asignaturaService.updateAsignaturaById(id_Asignatura, asignaturaInputDto));
        }catch (EntityNotFoundException e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }
}
