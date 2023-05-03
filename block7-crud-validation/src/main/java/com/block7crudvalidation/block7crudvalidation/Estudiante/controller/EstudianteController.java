package com.block7crudvalidation.block7crudvalidation.Estudiante.controller;

import com.block7crudvalidation.block7crudvalidation.Asignatura.controller.dto.AsignaturaInputDto;
import com.block7crudvalidation.block7crudvalidation.Estudiante.application.EstudianteService;
import com.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto.EstudianteInputDto;
import com.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto.EstudianteOutputDto;
import com.block7crudvalidation.block7crudvalidation.exception.domain.EntityNotFoundException;
import com.block7crudvalidation.block7crudvalidation.exception.domain.SQLIntegrityConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {
    @Autowired
    EstudianteService estudianteService;

    @PostMapping
    public ResponseEntity<EstudianteOutputDto> addEstudiante(@RequestBody EstudianteInputDto estudianteInputDto) throws EntityNotFoundException, SQLIntegrityConstraintViolationException {
        try {
            URI location = URI.create("/estudiante");
            return ResponseEntity.created(location).body(estudianteService.addEstudiante(estudianteInputDto));
        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException(e.getMessage());
        }catch (SQLIntegrityConstraintViolationException e){
            throw new SQLIntegrityConstraintViolationException(e.getMessage());
        }
    }
    @PostMapping("/asignaturas")
    public ResponseEntity<EstudianteOutputDto> addAsignaturas(@PathVariable int id_Estudiante, @RequestBody List<AsignaturaInputDto> asignaturaInputDtoList){
        return ResponseEntity.ok().body(estudianteService.addAsignaturas(id_Estudiante,asignaturaInputDtoList));
    }

    @GetMapping("/{id_Estudiante}")
    public ResponseEntity getEstudiante(@PathVariable int id_Estudiante, @RequestParam (defaultValue = "simple") String outputType) throws EntityNotFoundException {
        try{
            if(outputType.equals("full")) return ResponseEntity.ok().body(estudianteService.getEstudianteFull(id_Estudiante));
            else return ResponseEntity.ok().body(estudianteService.getEstudianteSimple(id_Estudiante));
        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<EstudianteOutputDto>> getEstudiantes(){
        return ResponseEntity.ok().body(estudianteService.getEstudiantes());
    }

    @DeleteMapping("/{id_Estudiante}")
    public ResponseEntity deleteEstudianteById(@PathVariable int id_Estudiante) throws EntityNotFoundException{
        try{
            estudianteService.deleteById_Estudiante(id_Estudiante);
            return ResponseEntity.ok().build();
        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    @PutMapping("/{id_Estudiante}")
    public ResponseEntity<EstudianteOutputDto> updateEstudiante(@PathVariable int id_Estudiante, @RequestBody EstudianteInputDto estudianteInputDto) throws EntityNotFoundException{
        try {
            return ResponseEntity.ok().body(estudianteService.updateEstudianteById(id_Estudiante, estudianteInputDto));
        }catch (EntityNotFoundException e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }
}
