package com.block7crudvalidation.block7crudvalidation.controller;

import com.block7crudvalidation.block7crudvalidation.application.Estudiante.EstudianteServiceImpl;
import com.block7crudvalidation.block7crudvalidation.application.Persona.PersonaServiceImpl;
import com.block7crudvalidation.block7crudvalidation.controller.dto.input.EstudianteInputDto;
import com.block7crudvalidation.block7crudvalidation.controller.dto.input.PersonaInputDto;
import com.block7crudvalidation.block7crudvalidation.controller.dto.output.CustomErrorOutputDto;
import com.block7crudvalidation.block7crudvalidation.controller.dto.output.EstudianteOutputDto;
import com.block7crudvalidation.block7crudvalidation.controller.dto.output.PersonaOutputDto;
import com.block7crudvalidation.block7crudvalidation.domain.exception.CustomError;
import com.block7crudvalidation.block7crudvalidation.domain.exception.EntityNotFoundException;
import com.block7crudvalidation.block7crudvalidation.domain.exception.UnprocessableEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/estudiante")
public class ControllerEstudiante {
    @Autowired
    EstudianteServiceImpl estudianteService;

    @PostMapping
    public ResponseEntity<EstudianteOutputDto> addEstudiante(@RequestBody EstudianteInputDto estudianteInputDto) throws EntityNotFoundException{
        URI location = URI.create("/estudiante");
        try {
            return ResponseEntity.created(location).body(estudianteService.addEstudiante(estudianteInputDto));
        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    @GetMapping("/{id_Estudiante}")
    public ResponseEntity<EstudianteOutputDto> getEstudianteById_Estudiante(@PathVariable int id_Estudiante) throws EntityNotFoundException {
        try{
            return ResponseEntity.ok().body(estudianteService.getEstudianteById_Estudiante(id_Estudiante));
        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    @GetMapping
    public List<EstudianteOutputDto> getEstudiantes(){
        return estudianteService.getEstudiantes();
    }

    @DeleteMapping("/{id_Estudiante}")
    public ResponseEntity<EstudianteOutputDto> deleteEstudianteById(@PathVariable int id_Estudiante) throws EntityNotFoundException{
        try{
            EstudianteOutputDto estudianteOutputDto = estudianteService.getEstudianteById_Estudiante(id_Estudiante);
            estudianteService.deleteById_Estudiante(id_Estudiante);
            return ResponseEntity.ok().body(estudianteOutputDto);
        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    @PutMapping("/{id_Estudiante}")
    public ResponseEntity<EstudianteOutputDto> updateEstudiante(@PathVariable int id_Estudiante, @RequestBody EstudianteInputDto estudianteInputDto) throws EntityNotFoundException {
        try {
            return ResponseEntity.ok().body(estudianteService.updatePersonaById_Estudiante(id_Estudiante, estudianteInputDto));
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException(e.getMessage());
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
