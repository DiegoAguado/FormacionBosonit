package com.block7crudvalidation.block7crudvalidation.application;

import com.block7crudvalidation.block7crudvalidation.controller.dto.CustomErrorOutputDto;
import com.block7crudvalidation.block7crudvalidation.domain.EntityNotFoundException;
import com.block7crudvalidation.block7crudvalidation.domain.UnprocessableEntityException;
import com.block7crudvalidation.block7crudvalidation.controller.dto.PersonaInputDto;
import com.block7crudvalidation.block7crudvalidation.controller.dto.PersonaOutputDto;
import com.block7crudvalidation.block7crudvalidation.domain.Persona;
import com.block7crudvalidation.block7crudvalidation.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaInputDto validacion(PersonaInputDto personaInputDto) throws UnprocessableEntityException {
        if (personaInputDto.getUsuario() == null)
            throw new UnprocessableEntityException("El usuario no puede ser nulo");
        if (personaInputDto.getUsuario().length() < 6 || personaInputDto.getUsuario().length() > 10)
            throw new UnprocessableEntityException("La longitud del usuario debe estar entre 6 y 10 caracteres");
        if (personaInputDto.getPassword() == null)
            throw new UnprocessableEntityException("La contraseña no puede ser nula");
        if (personaInputDto.getName() == null) throw new UnprocessableEntityException("El nombre no puede ser nulo");
        if (personaInputDto.getSurname() == null)
            throw new UnprocessableEntityException("El surname no puede ser nulo");
        if (personaInputDto.getCompany_email() == null)
            throw new UnprocessableEntityException("El correo de la compañía no puede ser nulo");
        if (personaInputDto.getPersonal_email() == null)
            throw new UnprocessableEntityException("El correo personal no puede ser nulo");
        if (personaInputDto.getCity() == null)
            throw new UnprocessableEntityException("La ciudad no puede ser nula");
        if (personaInputDto.getCreated_date() == null)
            throw new UnprocessableEntityException("La fecha de creación no puede ser nula");
        return personaInputDto;
    }

    @Override
    public PersonaOutputDto addPersona(PersonaInputDto personaInputDto) {
        return personaRepository.save(new Persona(personaInputDto)).personaToPersonaOutputDto();
    }

    @Override
    public PersonaOutputDto getPersonaById_Persona(int id_Persona) throws EntityNotFoundException {
        return personaRepository.findById(id_Persona).orElseThrow(EntityNotFoundException::new).personaToPersonaOutputDto();
    }

    public List<Persona> getPersonaByUsuario(String usuario) throws EntityNotFoundException {
        return personaRepository.findByUsuarioLike(usuario);
    }

    public List<Persona> getPersonas() {
        return personaRepository.findAll();
    }

    public void deleteById_Persona(int id_Persona) throws EntityNotFoundException {
        personaRepository.findById(id_Persona).orElseThrow(EntityNotFoundException::new);
        personaRepository.deleteById(id_Persona);
    }

    public PersonaOutputDto updatePersonaById_Persona(int id_Persona, PersonaInputDto personaInputDto) throws EntityNotFoundException {
        Persona persona = new Persona(personaInputDto);
        persona.setId_persona(personaRepository.findById(id_Persona).orElseThrow(EntityNotFoundException::new).getId_persona());
        return personaRepository.save(persona).personaToPersonaOutputDto();
    }
}
