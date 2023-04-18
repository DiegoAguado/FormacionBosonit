package block7crud.block7crud.application;

import block7crud.block7crud.controller.dto.PersonaInputDto;
import block7crud.block7crud.controller.dto.PersonaOutputDto;
import block7crud.block7crud.domain.Persona;

import java.util.List;

public interface PersonaService {
    PersonaOutputDto addPersona(PersonaInputDto personaInputDto);
    List<Persona> getPersonasByNombre(String nombre);
    PersonaOutputDto getPersonaById(String id);
    List<Persona> getPersonas();
    PersonaOutputDto updatePersona(String nombre, PersonaInputDto personaInputDto);
    void deletePersonaById(String id);
}
