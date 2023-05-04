package com.block7crudvalidation.block7crudvalidation.Persona.application;

import com.block7crudvalidation.block7crudvalidation.Estudiante.domain.Estudiante;
import com.block7crudvalidation.block7crudvalidation.Estudiante.repository.EstudianteRepository;
import com.block7crudvalidation.block7crudvalidation.Profesor.controller.dto.ProfesorOutputDto;
import com.block7crudvalidation.block7crudvalidation.Profesor.domain.Profesor;
import com.block7crudvalidation.block7crudvalidation.Profesor.repository.ProfesorRepository;
import com.block7crudvalidation.block7crudvalidation.exception.domain.EntityNotFoundException;
import com.block7crudvalidation.block7crudvalidation.exception.domain.UnprocessableEntityException;
import com.block7crudvalidation.block7crudvalidation.Persona.controller.dto.PersonaInputDto;
import com.block7crudvalidation.block7crudvalidation.Persona.controller.dto.PersonaOutputDto;
import com.block7crudvalidation.block7crudvalidation.Persona.domain.Persona;
import com.block7crudvalidation.block7crudvalidation.Persona.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    PersonaRepository personaRepository;
    @Autowired
    EstudianteRepository estudianteRepository;
    @Autowired
    ProfesorRepository profesorRepository;

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
        Persona persona = new Persona(personaInputDto);
        return personaRepository.save(persona).personaToPersonOutputDto();
    }

    public Object getDetalles(int id_Persona) {
        Persona persona = personaRepository.findById(id_Persona).orElseThrow();
        Estudiante estudiante = persona.getEstudiante();
        Profesor profesor = persona.getProfesor();
        if (profesor != null) {
            return personaRepository.getPersonaProfesor(id_Persona).personaToPersonaProfesorOutputDto();
        } else if (estudiante != null) {
            return personaRepository.getPersonaEstudiante(id_Persona).personaToPersonaEstudianteOutputDto();
        } else {
            return persona.personaToPersonOutputDto();
        }
    }

    @Override
    public PersonaOutputDto getPersonaById_Persona(int id_Persona) throws EntityNotFoundException {
        return personaRepository.findById(id_Persona).orElseThrow(EntityNotFoundException::new).personaToPersonOutputDto();
    }

    @Override
    public List<PersonaOutputDto> getPersonaByUsuario(String usuario) throws EntityNotFoundException {
        return personaRepository.findByUsuarioLike(usuario).stream().map(Persona::personaToPersonOutputDto).toList();
    }

    @Override
    public List<PersonaOutputDto> getPersonas() {
        return personaRepository.findAll().stream().map(Persona::personaToPersonOutputDto).toList();
    }

    @Override
    public void deleteById_Persona(int id_Persona) throws EntityNotFoundException {
        personaRepository.findById(id_Persona).orElseThrow(EntityNotFoundException::new);
        personaRepository.deleteById(id_Persona);
    }

    @Override
    public PersonaOutputDto updatePersonaById_Persona(int id_Persona, PersonaInputDto personaInputDto) throws EntityNotFoundException {
        Persona persona = new Persona(personaInputDto);
        persona.setId_persona(personaRepository.findById(id_Persona).orElseThrow(EntityNotFoundException::new).getId_persona());
        return personaRepository.save(persona).personaToPersonOutputDto();
    }
}
