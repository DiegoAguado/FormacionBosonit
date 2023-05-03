package com.block7crudvalidation.block7crudvalidation.Profesor.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfesorInputDto {
    int id_Profesor;
    int id_Persona;
    String comments;
    String branch;
}
