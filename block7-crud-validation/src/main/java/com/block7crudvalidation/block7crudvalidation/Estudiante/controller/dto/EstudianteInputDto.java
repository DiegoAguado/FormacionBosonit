package com.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto.input;

import com.block7crudvalidation.block7crudvalidation.Estudiante.domain.Estudiante_Asignatura;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteInputDto {
    int id_Persona;
    Integer num_hours_week;
    String comments;
    int id_Profesor;
    String branch;
    List<Estudiante_Asignatura> estudios;
}
