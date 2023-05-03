package com.block7crudvalidation.block7crudvalidation.Profesor.application;

import com.block7crudvalidation.block7crudvalidation.Estudiante.application.EstudianteService;
import com.block7crudvalidation.block7crudvalidation.Estudiante.application.EstudianteServiceImpl;
import com.block7crudvalidation.block7crudvalidation.Estudiante.domain.Estudiante;
import com.block7crudvalidation.block7crudvalidation.Estudiante.repository.EstudianteRepository;
import com.block7crudvalidation.block7crudvalidation.Persona.domain.Persona;
import com.block7crudvalidation.block7crudvalidation.Persona.repository.PersonaRepository;
import com.block7crudvalidation.block7crudvalidation.Profesor.controller.dto.ProfesorFullOutputDto;
import com.block7crudvalidation.block7crudvalidation.Profesor.controller.dto.ProfesorInputDto;
import com.block7crudvalidation.block7crudvalidation.Profesor.controller.dto.ProfesorOutputDto;
import com.block7crudvalidation.block7crudvalidation.Profesor.domain.Profesor;
import com.block7crudvalidation.block7crudvalidation.Profesor.repository.ProfesorRepository;
import com.block7crudvalidation.block7crudvalidation.exception.domain.EntityNotFoundException;
import com.block7crudvalidation.block7crudvalidation.exception.domain.SQLIntegrityConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService {
    @Autowired
    ProfesorRepository profesorRepository;
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public ProfesorOutputDto addProfesor(ProfesorInputDto profesorInputDto) throws EntityNotFoundException, SQLIntegrityConstraintViolationException {
        Persona persona = personaRepository.findById(profesorInputDto.getId_Persona()).orElseThrow(EntityNotFoundException::new);
        if (persona.getEstudiante() == null && persona.getProfesor() == null) {
            Profesor profesor = new Profesor(profesorInputDto);
            profesor.setPersona(persona);
            return profesorRepository.save(profesor).profesorToProfesorOutputDto();
        }else{
            throw new SQLIntegrityConstraintViolationException();
        }
    }

    @Override
    public ProfesorFullOutputDto getProfesorFull(int id_Profesor) throws EntityNotFoundException {
        try {
            return profesorRepository.getProfesorById(id_Profesor).orElseThrow(EntityNotFoundException::new).profesorToProfesorFullOutputDto();
        } catch (Exception e) {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public ProfesorOutputDto getProfesorSimple(int id_Profesor) throws EntityNotFoundException {
        return profesorRepository.getProfesorById(id_Profesor).orElseThrow(EntityNotFoundException::new).profesorToProfesorOutputDto();
    }

    @Override
    public List<ProfesorOutputDto> getProfesores() {
        return profesorRepository.findAll().stream().map(Profesor::profesorToProfesorOutputDto).toList();
    }

    @Override
    public void deleteById_Profesor(int id_Profesor) throws EntityNotFoundException {
        profesorRepository.getProfesorById(id_Profesor).orElseThrow(EntityNotFoundException::new);
        profesorRepository.deleteById(id_Profesor);
    }

    @Override
    public ProfesorOutputDto updateProfesorById(int id_Profesor, ProfesorInputDto profesorInputDto) throws EntityNotFoundException {
        Profesor profesor = profesorRepository.getProfesorById(profesorInputDto.getId_Profesor()).orElseThrow(EntityNotFoundException::new);
        profesor.setId_Profesor(profesorRepository.getProfesorById(id_Profesor).orElseThrow(EntityNotFoundException::new).getId_Profesor());
        return profesorRepository.save(profesor).profesorToProfesorOutputDto();
    }
}
