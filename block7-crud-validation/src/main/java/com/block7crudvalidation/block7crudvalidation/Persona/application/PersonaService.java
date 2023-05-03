package com.block7crudvalidation.block7crudvalidation.Persona.application;

import com.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto.EstudianteFullOutputDto;
import com.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto.EstudianteOutputDto;
import com.block7crudvalidation.block7crudvalidation.Persona.domain.Persona;
import com.block7crudvalidation.block7crudvalidation.Profesor.controller.dto.ProfesorFullOutputDto;
import com.block7crudvalidation.block7crudvalidation.exception.domain.EntityNotFoundException;
import com.block7crudvalidation.block7crudvalidation.exception.domain.UnprocessableEntityException;
import com.block7crudvalidation.block7crudvalidation.Persona.controller.dto.PersonaInputDto;
import com.block7crudvalidation.block7crudvalidation.Persona.controller.dto.PersonaOutputDto;

import java.util.List;

public interface PersonaService {
    PersonaInputDto validacion(PersonaInputDto personaInputDto) throws UnprocessableEntityException;
    PersonaOutputDto addPersona(PersonaInputDto personaInputDto);
    Object getDetalles(int id_Persona) throws EntityNotFoundException;
    PersonaOutputDto getPersonaById_Persona(int id_Persona) throws EntityNotFoundException;
    List<PersonaOutputDto> getPersonaByUsuario(String usuario) throws EntityNotFoundException;
    List<PersonaOutputDto> getPersonas();
    void deleteById_Persona(int id_Persona) throws EntityNotFoundException;
    PersonaOutputDto updatePersonaById_Persona(int id_Persona, PersonaInputDto personaInputDto)  throws EntityNotFoundException,UnprocessableEntityException;
}
