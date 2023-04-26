package com.formacion.examen_JPA_cascada.controller.dto.input;

import com.formacion.examen_JPA_cascada.domain.CabeceraFra;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteInputDto {
    private String nombre;
    private List<CabeceraFra> facturas;
}
