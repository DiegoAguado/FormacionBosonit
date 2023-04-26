package com.block7crudvalidation.block7crudvalidation.application.Persona;

import com.block7crudvalidation.block7crudvalidation.domain.exception.EntityNotFoundException;
import com.block7crudvalidation.block7crudvalidation.domain.exception.UnprocessableEntityException;
import com.block7crudvalidation.block7crudvalidation.controller.dto.input.PersonaInputDto;
import com.block7crudvalidation.block7crudvalidation.controller.dto.output.PersonaOutputDto;

import java.util.List;

public interface PersonaService {
    PersonaInputDto validacion(PersonaInputDto personaInputDto) throws UnprocessableEntityException;
    PersonaOutputDto addPersona(PersonaInputDto personaInputDto);
    PersonaOutputDto getPersonaById_Persona(int id_Persona) throws EntityNotFoundException;
    List<PersonaOutputDto> getPersonaByUsuario(String usuario) throws EntityNotFoundException;
    List<PersonaOutputDto> getPersonas();
    void deleteById_Persona(int id_Persona) throws EntityNotFoundException;
    PersonaOutputDto updatePersonaById_Persona(int id_Persona, PersonaInputDto personaInputDto)  throws EntityNotFoundException,UnprocessableEntityException;
}
