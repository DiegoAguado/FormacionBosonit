package com.block7crudvalidation.block7crudvalidation.Asignatura.application;

import com.block7crudvalidation.block7crudvalidation.Asignatura.controller.dto.AsignaturaInputDto;
import com.block7crudvalidation.block7crudvalidation.Asignatura.controller.dto.AsignaturaOutputDto;
import com.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto.EstudianteFullOutputDto;
import com.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto.EstudianteInputDto;
import com.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto.EstudianteOutputDto;
import com.block7crudvalidation.block7crudvalidation.exception.domain.EntityNotFoundException;
import com.block7crudvalidation.block7crudvalidation.exception.domain.SQLIntegrityConstraintViolationException;

import java.util.List;

public interface AsignaturaService {
    AsignaturaOutputDto addAsignatura(AsignaturaInputDto asignaturaInputDto) throws EntityNotFoundException;
    AsignaturaOutputDto getAsignatura(int id_Asignatura) throws EntityNotFoundException;
    List<AsignaturaOutputDto> getAsignaturas();
    List<AsignaturaOutputDto> getAsignaturasByEstudiante(int id_Estudiante);
    void deleteById_Asignatura(int id_Asignatura) throws EntityNotFoundException;
    AsignaturaOutputDto updateAsignaturaById(int id_Asignatura, AsignaturaInputDto asignaturaInputDto) throws EntityNotFoundException;
}
