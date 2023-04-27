package com.formacion.examen_JPA_cascada.application;

import com.formacion.examen_JPA_cascada.controller.dto.input.LineasFraInputDto;
import com.formacion.examen_JPA_cascada.controller.dto.output.CabeceraFraOutputDto;
import com.formacion.examen_JPA_cascada.controller.dto.output.LineasFraOutputDto;
import com.formacion.examen_JPA_cascada.domain.CabeceraFra;
import com.formacion.examen_JPA_cascada.domain.LineasFra;
import com.formacion.examen_JPA_cascada.repository.CabeceraFraRepository;
import com.formacion.examen_JPA_cascada.repository.LineasFraRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineasFraServiceImpl implements LineasFraService{
    @Autowired
    LineasFraRepository lineasFraRepository;
    @Autowired
    CabeceraFraRepository cabeceraFraRepository;

    @Override
    public LineasFraOutputDto addLinea(int idFra, LineasFraInputDto lineasFraInputDto) throws EntityNotFoundException {
        CabeceraFra cabeceraFra = cabeceraFraRepository.findById(idFra).orElseThrow(EntityNotFoundException::new);
        lineasFraInputDto.setIdFra(idFra);
        LineasFra lineasFra = new LineasFra(lineasFraInputDto);
        lineasFra.setIdFra(cabeceraFra);
        return lineasFraRepository.save(lineasFra).lineasFraToLineasFraOutputDto();
    }
}
