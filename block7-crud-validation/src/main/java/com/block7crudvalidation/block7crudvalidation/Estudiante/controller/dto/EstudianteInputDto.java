package com.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto;

import com.block7crudvalidation.block7crudvalidation.Asignatura.domain.Asignatura;
import lombok.*;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteInputDto {
    int id_Persona;
    int num_hours_week;
    String comments;
    String id_Profesor;
    String branch;
    ArrayList<Asignatura> asignaturas;
}
