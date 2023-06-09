package com.block7crudvalidation.block7crudvalidation.Asignatura.controller.dto;

import com.block7crudvalidation.block7crudvalidation.Estudiante.domain.Estudiante;
import com.block7crudvalidation.block7crudvalidation.Profesor.domain.Profesor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignaturaOutputDto {
    int id_asignatura;
    Profesor profesor;
    List<Estudiante> estudiante;
    String asignatura;
    String comentarios;
    Date initial_date;
    Date finish_date;
}
