package com.block7crudvalidation.block7crudvalidation.application;

import com.block7crudvalidation.block7crudvalidation.domain.EntityNotFoundException;
import com.block7crudvalidation.block7crudvalidation.domain.UnprocessableEntityException;
import com.block7crudvalidation.block7crudvalidation.controller.dto.PersonaInputDto;
import com.block7crudvalidation.block7crudvalidation.controller.dto.PersonaOutputDto;
import com.block7crudvalidation.block7crudvalidation.domain.Persona;

import java.util.List;

public interface PersonaService {
    PersonaInputDto validacion(PersonaInputDto personaInputDto) throws UnprocessableEntityException;
    PersonaOutputDto addPersona(PersonaInputDto personaInputDto);
    PersonaOutputDto getPersonaById_Persona(int id_Persona) throws EntityNotFoundException;
    List<Persona> getPersonaByUsuario(String usuario) throws EntityNotFoundException;
    List<Persona> getPersonas();
    void deleteById_Persona(int id_Persona) throws EntityNotFoundException;
    PersonaOutputDto updatePersonaById_Persona(int id_Persona, PersonaInputDto personaInputDto)  throws EntityNotFoundException,UnprocessableEntityException;
}
