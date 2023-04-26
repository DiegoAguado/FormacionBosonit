package com.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto.output;

import com.block7crudvalidation.block7crudvalidation.Profesor.domain.Profesor;
import com.block7crudvalidation.block7crudvalidation.Estudiante.domain.Estudiante_Asignatura;
import com.block7crudvalidation.block7crudvalidation.Persona.domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteOutputDto {
    Integer id_Estudiante;
    Persona persona;
    Integer num_hours_week;
    String comments;
    Profesor profesor;
    String branch;
    List<Estudiante_Asignatura> estudios;
}
