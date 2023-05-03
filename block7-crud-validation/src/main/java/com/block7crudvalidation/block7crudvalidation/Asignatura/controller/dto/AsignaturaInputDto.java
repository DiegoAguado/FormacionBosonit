package com.block7crudvalidation.block7crudvalidation.Asignatura.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignaturaInputDto {
    int id_Profesor;
    String asignatura;
    String comentarios;
    Date initial_date;
    Date finish_date;
}
