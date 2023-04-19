package com.block7crudvalidation.block7crudvalidation.application;

import com.block7crudvalidation.block7crudvalidation.controller.dto.PersonaInputDto;
import com.block7crudvalidation.block7crudvalidation.controller.dto.PersonaOutputDto;
import com.block7crudvalidation.block7crudvalidation.domain.Persona;

import java.util.List;

public interface PersonaService {
    PersonaInputDto validacion(PersonaInputDto personaInputDto) throws  Exception;
    PersonaOutputDto addPersona(PersonaInputDto personaInputDto);
    PersonaOutputDto findById(int id);
    List<Persona> findByUsuario(String usuario);
    List<Persona> getPersonas();
}
