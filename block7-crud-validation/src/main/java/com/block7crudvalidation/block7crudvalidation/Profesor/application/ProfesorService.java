package com.block7crudvalidation.block7crudvalidation.Profesor.application;

import com.block7crudvalidation.block7crudvalidation.Profesor.controller.dto.ProfesorFullOutputDto;
import com.block7crudvalidation.block7crudvalidation.Profesor.controller.dto.ProfesorInputDto;
import com.block7crudvalidation.block7crudvalidation.Profesor.controller.dto.ProfesorOutputDto;
import com.block7crudvalidation.block7crudvalidation.exception.domain.EntityNotFoundException;
import com.block7crudvalidation.block7crudvalidation.exception.domain.SQLIntegrityConstraintViolationException;

import java.util.List;

public interface ProfesorService {
    ProfesorOutputDto addProfesor(ProfesorInputDto profesorInputDto) throws EntityNotFoundException, SQLIntegrityConstraintViolationException;
    ProfesorFullOutputDto getProfesorFull(int id_Profesor) throws EntityNotFoundException;
    ProfesorOutputDto getProfesorSimple(int id_Profesor) throws EntityNotFoundException;
    List<ProfesorOutputDto> getProfesores();
    void deleteById_Profesor(int id_Profesor) throws EntityNotFoundException;
    ProfesorOutputDto updateProfesorById(int id_Profesor, ProfesorInputDto profesorInputDto) throws EntityNotFoundException;
}
