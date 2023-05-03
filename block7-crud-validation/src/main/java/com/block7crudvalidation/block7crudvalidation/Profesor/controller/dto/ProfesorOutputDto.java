package com.block7crudvalidation.block7crudvalidation.Profesor.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfesorOutputDto {
    int id_Profesor;
    int id_persona;
    String comments;
    String branch;
}
