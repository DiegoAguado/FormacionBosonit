package com.formacion.examen_JPA_cascada.domain;

import com.formacion.examen_JPA_cascada.controller.dto.input.ClienteInputDto;
import com.formacion.examen_JPA_cascada.controller.dto.output.ClienteOutputDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_cliente;
    @Column(nullable = false)
    @Size(max = 100)
    private String nombre;
    @OneToMany(mappedBy = "cli_codi")
    private List<CabeceraFra> facturas;

    public ClienteOutputDto clienteToClienteOutputDto(){
        return new ClienteOutputDto(this.id_cliente, this.nombre);
    }

    public Cliente (ClienteInputDto clienteInputDto) {
        this.nombre = clienteInputDto.getNombre();
        this.facturas = clienteInputDto.getFacturas();
    }
}
