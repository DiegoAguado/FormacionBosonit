package com.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto;

import com.block7crudvalidation.block7crudvalidation.Asignatura.domain.Asignatura;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteOutputDto {
    int id_Estudiante;
    int id_persona;
    int num_hours_week;
    String comments;
    String branch;
    int id_profesor;
    List<Asignatura> asignaturas;
}
