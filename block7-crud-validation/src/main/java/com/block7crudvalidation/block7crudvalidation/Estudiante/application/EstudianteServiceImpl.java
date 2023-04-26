package com.block7crudvalidation.block7crudvalidation.application.Estudiante;

import com.block7crudvalidation.block7crudvalidation.controller.dto.input.EstudianteInputDto;
import com.block7crudvalidation.block7crudvalidation.controller.dto.output.EstudianteOutputDto;
import com.block7crudvalidation.block7crudvalidation.domain.Estudiante;
import com.block7crudvalidation.block7crudvalidation.domain.Persona;
import com.block7crudvalidation.block7crudvalidation.domain.exception.CustomError;
import com.block7crudvalidation.block7crudvalidation.domain.exception.EntityNotFoundException;
import com.block7crudvalidation.block7crudvalidation.domain.mapper.EstudianteMapper;
import com.block7crudvalidation.block7crudvalidation.repository.EstudianteRepository;
import com.block7crudvalidation.block7crudvalidation.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EstudianteServiceImpl implements EstudianteService{
    @Autowired
    EstudianteRepository estudianteRepository;
    @Autowired
    PersonaRepository personaRepository;
    @Override
    public EstudianteOutputDto addEstudiante(EstudianteInputDto estudianteInputDto) throws EntityNotFoundException{

        Estudiante estudiante = EstudianteMapper.mapper.estudianteInputDtoToEstudiante(estudianteInputDto);
        estudiante.setPersona(personaRepository.findById(estudianteInputDto.getId_Persona()).orElseThrow());
        return EstudianteMapper.mapper
                .estudianteToEstudianteOutputDto(
                        estudianteRepository.save(estudiante));
    }
    @Override
    public EstudianteOutputDto getEstudianteById_Estudiante(int id_Estudiante) throws EntityNotFoundException{
        return EstudianteMapper.mapper
                .estudianteToEstudianteOutputDto(
                        estudianteRepository.findById(
                                id_Estudiante).orElseThrow(EntityNotFoundException::new));
    }
    @Override
    public List<EstudianteOutputDto> getEstudiantes(){
        return estudianteRepository.findAll().stream().map(EstudianteMapper.mapper::estudianteToEstudianteOutputDto).toList();
    }
    @Override
    public void deleteById_Estudiante(int id_Estudiante) throws EntityNotFoundException{
        estudianteRepository.findById(id_Estudiante).orElseThrow(EntityNotFoundException::new);
        estudianteRepository.deleteById(id_Estudiante);
    }
    @Override
    public EstudianteOutputDto updatePersonaById_Estudiante(int id_Estudiante, EstudianteInputDto estudianteInputDto)  throws EntityNotFoundException{
        Estudiante estudiante = EstudianteMapper.mapper.estudianteInputDtoToEstudiante(estudianteInputDto);
        estudiante.setPersona(personaRepository.findById(id_Estudiante).orElseThrow());
        return EstudianteMapper.mapper
                .estudianteToEstudianteOutputDto(
                        estudianteRepository.save(estudiante));
    }
}
