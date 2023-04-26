package com.formacion.examen_JPA_cascada.application;

import com.formacion.examen_JPA_cascada.controller.dto.output.CabeceraFraOutputDto;
import com.formacion.examen_JPA_cascada.controller.dto.output.LineasFraOutputDto;
import com.formacion.examen_JPA_cascada.domain.CabeceraFra;
import com.formacion.examen_JPA_cascada.domain.LineasFra;
import com.formacion.examen_JPA_cascada.repository.CabeceraFraRepository;
import com.formacion.examen_JPA_cascada.repository.LineasFraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineasFraServiceImpl implements LineasFraService{
    @Autowired
    LineasFraRepository lineasFraRepository;

    @Override
    public List<LineasFraOutputDto> getAllLineas(){
        return lineasFraRepository.findAll().stream().map(LineasFra::lineasFraToLineasFraOutputDto).toList();
    }
}
