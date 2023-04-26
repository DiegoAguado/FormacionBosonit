package com.formacion.examen_JPA_cascada.application;

import com.formacion.examen_JPA_cascada.controller.dto.output.ClienteOutputDto;
import com.formacion.examen_JPA_cascada.domain.Cliente;
import com.formacion.examen_JPA_cascada.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<ClienteOutputDto> getAllClientes(){
        return clienteRepository.findAll().stream().map(Cliente::clienteToClienteOutputDto).toList();
    }
}
