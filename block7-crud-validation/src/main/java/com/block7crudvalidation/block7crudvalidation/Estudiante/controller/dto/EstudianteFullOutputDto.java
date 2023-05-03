package com.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto;

import com.block7crudvalidation.block7crudvalidation.Asignatura.domain.Asignatura;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteFullOutputDto {
    Integer id_Estudiante;
    Integer num_hours_week;
    String comments;
    int id_Profesor;
    String branch;
    List<Asignatura> asignaturas;
    Integer id_persona;
    String usuario;
    String password;
    String name;
    String surname;
    String company_email;
    String personal_email;
    String city;
    boolean active;
    Date created_date;
    String imagen_url;
    Date termination_date;
}
