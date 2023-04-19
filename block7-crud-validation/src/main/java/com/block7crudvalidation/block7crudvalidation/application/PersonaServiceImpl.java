package com.block7crudvalidation.block7crudvalidation.application;

import com.block7crudvalidation.block7crudvalidation.controller.dto.PersonaInputDto;
import com.block7crudvalidation.block7crudvalidation.controller.dto.PersonaOutputDto;
import com.block7crudvalidation.block7crudvalidation.domain.Persona;
import com.block7crudvalidation.block7crudvalidation.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService{
    @Autowired
    PersonaRepository personaRepository;
    @Override
    public PersonaInputDto validacion(PersonaInputDto personaInputDto) throws  Exception{
        if(personaInputDto.getUsuario()==null) throw new Exception("El usuario no puede ser nulo");
        if(personaInputDto.getUsuario().length() < 6 || personaInputDto.getUsuario().length() > 10) throw new Exception("La longitud del usuario debe estar entre 6 y 10 caracteres");
        if(personaInputDto.getPassword()==null) throw new Exception("La contraseña no puede ser nula");
        if(personaInputDto.getName()==null) throw new Exception("El nombre no puede ser nulo");
        if(personaInputDto.getSurname()==null) throw new Exception("El surname no puede ser nulo");
        if(personaInputDto.getCompany_email()==null) throw new Exception("El correo de la compañía no puede ser nulo");
        if(personaInputDto.getPersonal_email()==null) throw new Exception("El correo personal no puede ser nulo");
        if(personaInputDto.getCity()==null) throw new Exception("La ciudad no puede ser nula");
        if(personaInputDto.getCreated_date()==null) throw new Exception("La fecha de creación no puede ser nula");
        return personaInputDto;
    }

    @Override
    public PersonaOutputDto addPersona(PersonaInputDto personaInputDto){
        try {
            return personaRepository.save(new Persona(validacion(personaInputDto))).personaToPersonaOutputDto();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public PersonaOutputDto findById(int id){
        return personaRepository.findById(id).orElseThrow().personaToPersonaOutputDto();
    }

    @Override
    public List<Persona> findByUsuario(String usuario){
        return personaRepository.findByUsuarioLike(usuario);
    }

    @Override
    public List<Persona> getPersonas(){
        return personaRepository.findAll();
    }
}
