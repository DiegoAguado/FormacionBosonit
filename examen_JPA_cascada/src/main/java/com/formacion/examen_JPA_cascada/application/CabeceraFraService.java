package com.formacion.examen_JPA_cascada.application;

import com.formacion.examen_JPA_cascada.controller.dto.input.LineasFraInputDto;
import com.formacion.examen_JPA_cascada.controller.dto.output.CabeceraFraOutputDto;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface CabeceraFraService {
    List<CabeceraFraOutputDto> getAllFacturas();
    public void deleteFactura(int idFra)throws EntityNotFoundException;
}
