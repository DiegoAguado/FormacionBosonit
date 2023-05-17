package com.formacionBack.block10dockerizeapp.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaInputDto {
    String nombre;
    String edad;
    String poblacion;
}
