package com.block7crudvalidation.block7crudvalidation.application.Estudiante;

import com.block7crudvalidation.block7crudvalidation.controller.dto.input.EstudianteInputDto;
import com.block7crudvalidation.block7crudvalidation.controller.dto.input.PersonaInputDto;
import com.block7crudvalidation.block7crudvalidation.controller.dto.output.EstudianteOutputDto;
import com.block7crudvalidation.block7crudvalidation.controller.dto.output.PersonaOutputDto;
import com.block7crudvalidation.block7crudvalidation.domain.Estudiante;
import com.block7crudvalidation.block7crudvalidation.domain.Persona;
import com.block7crudvalidation.block7crudvalidation.domain.exception.CustomError;
import com.block7crudvalidation.block7crudvalidation.domain.exception.EntityNotFoundException;
import com.block7crudvalidation.block7crudvalidation.domain.exception.UnprocessableEntityException;

import java.util.List;

public interface EstudianteService {
    EstudianteOutputDto addEstudiante(EstudianteInputDto estudianteInputDto) throws EntityNotFoundException;
    EstudianteOutputDto getEstudianteById_Estudiante(int id_Estudiante) throws EntityNotFoundException;
    List<EstudianteOutputDto> getEstudiantes();
    void deleteById_Estudiante(int id_Estudiante) throws EntityNotFoundException;
    EstudianteOutputDto updatePersonaById_Estudiante(int id_Estudiante, EstudianteInputDto estudianteInputDto)  throws EntityNotFoundException,UnprocessableEntityException;
}
