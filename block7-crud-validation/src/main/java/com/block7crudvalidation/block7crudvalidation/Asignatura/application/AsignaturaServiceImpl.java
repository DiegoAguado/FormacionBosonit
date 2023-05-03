package com.block7crudvalidation.block7crudvalidation.Asignatura.application;

import com.block7crudvalidation.block7crudvalidation.Asignatura.controller.dto.AsignaturaInputDto;
import com.block7crudvalidation.block7crudvalidation.Asignatura.controller.dto.AsignaturaOutputDto;
import com.block7crudvalidation.block7crudvalidation.Asignatura.domain.Asignatura;
import com.block7crudvalidation.block7crudvalidation.Asignatura.repository.AsignaturaRepository;
import com.block7crudvalidation.block7crudvalidation.Profesor.domain.Profesor;
import com.block7crudvalidation.block7crudvalidation.Profesor.repository.ProfesorRepository;
import com.block7crudvalidation.block7crudvalidation.exception.domain.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {
    @Autowired
    AsignaturaRepository asignaturaRepository;
    @Autowired
    ProfesorRepository profesorRepository;

    @Override
    public AsignaturaOutputDto addAsignatura(AsignaturaInputDto asignaturaInputDto) throws EntityNotFoundException{
        Profesor profesor = profesorRepository.getProfesorById(asignaturaInputDto.getId_Profesor()).orElseThrow(EntityNotFoundException::new);
        Asignatura asignatura = new Asignatura(asignaturaInputDto);
        asignatura.setProfesor(profesor);
        return asignaturaRepository.save(asignatura).asignaturaToAsignaturaOutputDto();
    }

    @Override
    public AsignaturaOutputDto getAsignatura(int id_asignatura) throws EntityNotFoundException {
        try {
            return asignaturaRepository.findById(id_asignatura).orElseThrow(EntityNotFoundException::new).asignaturaToAsignaturaOutputDto();
        } catch (Exception e) {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public List<AsignaturaOutputDto> getAsignaturas() {
        return asignaturaRepository.findAll().stream().map(Asignatura::asignaturaToAsignaturaOutputDto).toList();
    }

    @Override
    public List<AsignaturaOutputDto> getAsignaturasByEstudiante(int id_Estudiante) {
        return asignaturaRepository.getByEstudiante(id_Estudiante).stream().map(Asignatura::asignaturaToAsignaturaOutputDto).toList();
    }

    @Override
    public void deleteById_Asignatura(int id_asignatura) throws EntityNotFoundException {
        asignaturaRepository.findById(id_asignatura).orElseThrow(EntityNotFoundException::new);
        asignaturaRepository.deleteById(id_asignatura);
    }

    @Override
    public AsignaturaOutputDto updateAsignaturaById(int id_asignatura, AsignaturaInputDto asignaturaInputDto) throws EntityNotFoundException {
        asignaturaRepository.findById(id_asignatura).orElseThrow(EntityNotFoundException::new);
        Asignatura asignatura = new Asignatura(asignaturaInputDto);
        asignatura.setId_asignatura(asignaturaRepository.findById(id_asignatura).orElseThrow(EntityNotFoundException::new).getId_asignatura());
        return asignaturaRepository.save(asignatura).asignaturaToAsignaturaOutputDto();
    }
}
