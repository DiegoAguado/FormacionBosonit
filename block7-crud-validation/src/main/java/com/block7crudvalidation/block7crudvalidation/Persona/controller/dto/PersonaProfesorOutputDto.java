package com.block7crudvalidation.block7crudvalidation.Persona.controller.dto;

import com.block7crudvalidation.block7crudvalidation.Profesor.controller.dto.ProfesorOutputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class PersonaProfesorOutputDto {
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
    ProfesorOutputDto profesorOutputDto;
}
