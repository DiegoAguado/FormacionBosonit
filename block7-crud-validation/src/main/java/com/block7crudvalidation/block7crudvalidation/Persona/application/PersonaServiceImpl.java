package com.block7crudvalidation.block7crudvalidation.application.Persona;

import com.block7crudvalidation.block7crudvalidation.domain.exception.EntityNotFoundException;
import com.block7crudvalidation.block7crudvalidation.domain.exception.UnprocessableEntityException;
import com.block7crudvalidation.block7crudvalidation.controller.dto.input.PersonaInputDto;
import com.block7crudvalidation.block7crudvalidation.controller.dto.output.PersonaOutputDto;
import com.block7crudvalidation.block7crudvalidation.domain.Persona;
import com.block7crudvalidation.block7crudvalidation.domain.mapper.PersonaMapper;
import com.block7crudvalidation.block7crudvalidation.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        Persona persona = PersonaMapper.mapper.personaInputDtoToPersona(personaInputDto);
        return PersonaMapper.mapper
                .personaToPersonOutputDto(
                        personaRepository.save(persona));
    }

    @Override
    public PersonaOutputDto getPersonaById_Persona(int id_Persona) throws EntityNotFoundException {
        return PersonaMapper.mapper
                .personaToPersonOutputDto(
                        personaRepository.findById(
                                id_Persona).orElseThrow(EntityNotFoundException::new));
    }

    public List<PersonaOutputDto> getPersonaByUsuario(String usuario) throws EntityNotFoundException {
        return personaRepository.findByUsuarioLike(usuario).stream().map(PersonaMapper.mapper::personaToPersonOutputDto).toList();
    }

    public List<PersonaOutputDto> getPersonas() {
        return personaRepository.findAll().stream().map(PersonaMapper.mapper::personaToPersonOutputDto).toList();
    }

    public void deleteById_Persona(int id_Persona) throws EntityNotFoundException {
        personaRepository.findById(id_Persona).orElseThrow(EntityNotFoundException::new);
        personaRepository.deleteById(id_Persona);
    }

    public PersonaOutputDto updatePersonaById_Persona(int id_Persona, PersonaInputDto personaInputDto) throws EntityNotFoundException {
        Persona persona = PersonaMapper.mapper.personaInputDtoToPersona(personaInputDto);
        persona.setId_persona(personaRepository.findById(id_Persona).orElseThrow(EntityNotFoundException::new).getId_persona());
        return PersonaMapper.mapper.personaToPersonOutputDto(personaRepository.save(persona));
    }
}
