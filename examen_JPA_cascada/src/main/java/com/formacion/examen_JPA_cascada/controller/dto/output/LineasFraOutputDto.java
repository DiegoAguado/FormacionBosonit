package com.formacion.examen_JPA_cascada.controller.dto.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LineasFraOutputDto {
    private int idFra;
    private String producto;
    private double cantidad;
    private double importe;
}
