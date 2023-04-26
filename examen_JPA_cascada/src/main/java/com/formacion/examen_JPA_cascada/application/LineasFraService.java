package com.formacion.examen_JPA_cascada.application;

import com.formacion.examen_JPA_cascada.controller.dto.output.LineasFraOutputDto;

import java.util.List;

public interface LineasFraService {
    public List<LineasFraOutputDto> getAllLineas();
}
