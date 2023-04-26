package com.formacion.examen_JPA_cascada.application;

import com.formacion.examen_JPA_cascada.controller.dto.output.ClienteOutputDto;

import java.util.List;

public interface ClienteService {
    public List<ClienteOutputDto> getAllClientes();
}
