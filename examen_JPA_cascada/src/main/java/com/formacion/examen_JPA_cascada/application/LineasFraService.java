package com.formacion.examen_JPA_cascada.application;

import com.formacion.examen_JPA_cascada.controller.dto.input.LineasFraInputDto;
import com.formacion.examen_JPA_cascada.controller.dto.output.CabeceraFraOutputDto;
import com.formacion.examen_JPA_cascada.controller.dto.output.LineasFraOutputDto;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface LineasFraService {
    public LineasFraOutputDto addLinea(int idFra, LineasFraInputDto lineasFraInputDto) throws EntityNotFoundException;
}
