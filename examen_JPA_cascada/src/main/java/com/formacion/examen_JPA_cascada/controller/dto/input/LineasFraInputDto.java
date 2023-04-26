package com.formacion.examen_JPA_cascada.controller.dto.input;

import com.formacion.examen_JPA_cascada.domain.CabeceraFra;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LineasFraInputDto {
    private CabeceraFra idFra;
    private String proNomb;
    private double cantidad;
    private double precio;
}
