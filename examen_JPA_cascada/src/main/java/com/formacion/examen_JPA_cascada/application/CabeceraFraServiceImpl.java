package com.formacion.examen_JPA_cascada.application;

import com.formacion.examen_JPA_cascada.controller.dto.input.LineasFraInputDto;
import com.formacion.examen_JPA_cascada.controller.dto.output.CabeceraFraOutputDto;
import com.formacion.examen_JPA_cascada.domain.CabeceraFra;
import com.formacion.examen_JPA_cascada.domain.LineasFra;
import com.formacion.examen_JPA_cascada.repository.CabeceraFraRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CabeceraFraServiceImpl implements CabeceraFraService{

    @Autowired
    CabeceraFraRepository cabeceraFraRepository;

    @Override
    public List<CabeceraFraOutputDto> getAllFacturas(){
        return cabeceraFraRepository.findAll().stream().map(CabeceraFra::cabeceraFraToCabeceraFraOutputDto).toList();
    }

    @Override
    public void deleteFactura(int idFra) throws EntityNotFoundException {
        cabeceraFraRepository.findById(idFra).orElseThrow(EntityNotFoundException::new);
        cabeceraFraRepository.deleteById(idFra);
    }
}
