package com.formacion.examen_JPA_cascada.controller.dto.output;

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
public class CabeceraFraOutputDto {
    private int id;
    private ClienteOutputDto clienteOutputDto;
    private double importeFra=0;
    private List<LineasFraOutputDto> lineasFraOutputDtoList;
}
