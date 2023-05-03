package com.block7crudvalidation.block7crudvalidation.Estudiante.application;

import com.block7crudvalidation.block7crudvalidation.Asignatura.controller.AsignaturaController;
import com.block7crudvalidation.block7crudvalidation.Asignatura.controller.dto.AsignaturaInputDto;
import com.block7crudvalidation.block7crudvalidation.Asignatura.domain.Asignatura;
import com.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto.EstudianteInputDto;
import com.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto.EstudianteOutputDto;
import com.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto.EstudianteFullOutputDto;
import com.block7crudvalidation.block7crudvalidation.Estudiante.domain.Estudiante;
import com.block7crudvalidation.block7crudvalidation.Persona.domain.Persona;
import com.block7crudvalidation.block7crudvalidation.Profesor.application.ProfesorService;
import com.block7crudvalidation.block7crudvalidation.exception.domain.EntityNotFoundException;
import com.block7crudvalidation.block7crudvalidation.Estudiante.repository.EstudianteRepository;
import com.block7crudvalidation.block7crudvalidation.Persona.repository.PersonaRepository;
import com.block7crudvalidation.block7crudvalidation.exception.domain.SQLIntegrityConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService {
    @Autowired
    EstudianteRepository estudianteRepository;
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public EstudianteOutputDto addEstudiante(EstudianteInputDto estudianteInputDto) throws EntityNotFoundException {
        Persona persona = personaRepository.findById(estudianteInputDto.getId_Persona()).orElseThrow(EntityNotFoundException::new);
        Estudiante estudiante = new Estudiante(estudianteInputDto);
        estudiante.setPersona(persona);
        return estudianteRepository.save(estudiante).estudianteToEstudianteOutputDto();
    }

    @Override
    public EstudianteOutputDto addAsignaturas(int id_Estudiante, List<AsignaturaInputDto> asignaturaInputDto) {
        Estudiante estudiante = estudianteRepository.findById(id_Estudiante).orElseThrow();
        for (AsignaturaInputDto asignaturaInputDto1 : asignaturaInputDto) {
            estudiante.getAsignaturas().add(new Asignatura(asignaturaInputDto1));
        }
        return estudianteRepository.save(estudiante).estudianteToEstudianteOutputDto();
    }

    @Override
    public EstudianteFullOutputDto getEstudianteFull(int id_Estudiante) throws EntityNotFoundException {
        try {
            return estudianteRepository.getEstudianteById(id_Estudiante).orElseThrow(EntityNotFoundException::new).estudianteToEstudianteFullOutputDto();
        } catch (Exception e) {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public EstudianteOutputDto getEstudianteSimple(int id_Estudiante) throws EntityNotFoundException {
        return estudianteRepository.findById(id_Estudiante).orElseThrow(EntityNotFoundException::new).estudianteToEstudianteOutputDto();
    }

    @Override
    public List<EstudianteOutputDto> getEstudiantes() {
        return estudianteRepository.findAll().stream().map(Estudiante::estudianteToEstudianteOutputDto).toList();
    }

    @Override
    public void deleteById_Estudiante(int id_Estudiante) throws EntityNotFoundException {
        estudianteRepository.findById(id_Estudiante).orElseThrow(EntityNotFoundException::new);
        estudianteRepository.deleteById(id_Estudiante);
    }

    @Override
    public EstudianteOutputDto updateEstudianteById(int id_Estudiante, EstudianteInputDto estudianteInputDto) throws EntityNotFoundException {
        Persona persona = personaRepository.findById(estudianteInputDto.getId_Persona()).orElseThrow(EntityNotFoundException::new);
        Estudiante estudiante = new Estudiante(estudianteInputDto);
        estudiante.setId_Estudiante(id_Estudiante);
        estudiante.setPersona(persona);
        return estudianteRepository.save(estudiante).estudianteToEstudianteOutputDto();
    }
}
