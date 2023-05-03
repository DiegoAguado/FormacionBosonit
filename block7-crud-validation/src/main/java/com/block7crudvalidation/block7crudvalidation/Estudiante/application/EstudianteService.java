package com.block7crudvalidation.block7crudvalidation.Estudiante.application;

import com.block7crudvalidation.block7crudvalidation.Asignatura.controller.dto.AsignaturaInputDto;
import com.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto.EstudianteFullOutputDto;
import com.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto.EstudianteInputDto;
import com.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto.EstudianteOutputDto;
import com.block7crudvalidation.block7crudvalidation.exception.domain.EntityNotFoundException;
import com.block7crudvalidation.block7crudvalidation.exception.domain.SQLIntegrityConstraintViolationException;

import java.util.List;

public interface EstudianteService {
    EstudianteOutputDto addEstudiante(EstudianteInputDto estudianteInputDto) throws EntityNotFoundException, SQLIntegrityConstraintViolationException;
    EstudianteOutputDto addAsignaturas(int id_Estudiante, List<AsignaturaInputDto> asignaturaInputDto);
    EstudianteFullOutputDto getEstudianteFull(int id_Estudiante) throws EntityNotFoundException;
    EstudianteOutputDto getEstudianteSimple(int id_Estudiante) throws EntityNotFoundException;
    List<EstudianteOutputDto> getEstudiantes();
    void deleteById_Estudiante(int id_Estudiante) throws EntityNotFoundException;
    EstudianteOutputDto updateEstudianteById(int id_Estudiante, EstudianteInputDto estudianteInputDto) throws EntityNotFoundException;
}
