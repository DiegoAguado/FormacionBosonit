package com.block7crudvalidation.block7crudvalidation.Persona.controller.dto;

import com.block7crudvalidation.block7crudvalidation.Asignatura.domain.Asignatura;
import com.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto.EstudianteOutputDto;
import com.block7crudvalidation.block7crudvalidation.Estudiante.domain.Estudiante;
import com.block7crudvalidation.block7crudvalidation.Persona.domain.Persona;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaEstudianteOutputDto {
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
    EstudianteOutputDto estudianteOutputDto;
}
