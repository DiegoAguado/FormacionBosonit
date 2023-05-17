package com.formacionBack.block10dockerizeapp.application;



import com.formacionBack.block10dockerizeapp.controller.dto.PersonaInputDto;
import com.formacionBack.block10dockerizeapp.controller.dto.PersonaOutputDto;
import com.formacionBack.block10dockerizeapp.domain.Persona;

import java.util.List;

public interface PersonaService {
    PersonaOutputDto addPersona(PersonaInputDto personaInputDto);
    List<Persona> getPersonasByNombre(String nombre);
    PersonaOutputDto getPersonaById(String id);
    List<Persona> getPersonas();
    PersonaOutputDto updatePersona(String nombre, PersonaInputDto personaInputDto);
    void deletePersonaById(String id);
}
