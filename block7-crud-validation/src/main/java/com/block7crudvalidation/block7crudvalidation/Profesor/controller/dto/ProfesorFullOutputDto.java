package com.block7crudvalidation.block7crudvalidation.Profesor.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfesorFullOutputDto {
    int id_Profesor;
    int id_persona;
    String comments;
    String branch;
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
