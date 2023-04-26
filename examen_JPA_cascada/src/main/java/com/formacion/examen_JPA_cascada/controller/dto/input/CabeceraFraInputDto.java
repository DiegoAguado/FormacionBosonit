package com.formacion.examen_JPA_cascada.controller.dto.input;

import com.formacion.examen_JPA_cascada.domain.Cliente;
import com.formacion.examen_JPA_cascada.domain.LineasFra;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CabeceraFraInputDto {
    private Cliente cli_codi;
    private double importeFra;
    private List<LineasFra> lineas;
}
