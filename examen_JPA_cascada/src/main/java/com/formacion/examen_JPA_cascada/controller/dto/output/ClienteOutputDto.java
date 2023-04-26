package com.formacion.examen_JPA_cascada.controller.dto.output;

import com.formacion.examen_JPA_cascada.domain.CabeceraFra;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteOutputDto {
    private int id_cliente;
    private String nombre;
}
