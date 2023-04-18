package block7crud.block7crud.application;

import block7crud.block7crud.controller.dto.PersonaInputDto;
import block7crud.block7crud.controller.dto.PersonaOutputDto;
import block7crud.block7crud.domain.Persona;
import block7crud.block7crud.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService{
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutputDto addPersona(PersonaInputDto personaInputDto){
        return personaRepository
                .save(new Persona(personaInputDto))
                .personaToPersonaOutputDto();
    }

    @Override
    public List<Persona> getPersonasByNombre(String nombre){
        return personaRepository.findByNombreLike(nombre);
    }

    @Override
    public PersonaOutputDto getPersonaById(String id){
        return personaRepository.findById(id).orElseThrow().personaToPersonaOutputDto();
    }

    @Override
    public List<Persona> getPersonas(){
        return personaRepository.findAll();
    }

    @Override
    public PersonaOutputDto updatePersona(String id, PersonaInputDto personaInputDto){
        Persona persona = personaRepository.findById(id).orElseThrow();
        persona.setNombre(personaInputDto.getNombre());
        persona.setEdad(personaInputDto.getEdad());
        persona.setPoblacion(personaInputDto.getPoblacion());

        return personaRepository.save(persona).personaToPersonaOutputDto();
    }

    @Override
    public void deletePersonaById(String id){
        personaRepository.findById(id).orElseThrow();
        personaRepository.deleteById(id);
    }


}
