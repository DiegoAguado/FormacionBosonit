package com.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto.input;

import com.block7crudvalidation.block7crudvalidation.Estudiante.domain.Estudiante;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estudiante_AsignaturaInputDto {
    int  id_Profesor;
    List<Estudiante> estudiante;
    String asignatura;
    String comentarios;
    Date initial_date;
    Date finish_date;
}
