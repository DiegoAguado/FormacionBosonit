package com.block7crudvalidation.block7crudvalidation.domain;

import com.block7crudvalidation.block7crudvalidation.controller.dto.input.PersonaInputDto;
import com.block7crudvalidation.block7crudvalidation.controller.dto.output.PersonaOutputDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id_persona;
    @Column(name = "usuario")
    String usuario;
    @Column(name = "password")
    String password;
    @Column(name = "name")
    String name;
    @Column(name = "surname")
    String surname;
    @Column(name = "company_email")
    String company_email;
    @Column(name = "personal_email")
    String personal_email;
    @Column(name = "city")
    String city;
    @Column(name = "active")
    boolean active;
    @Column(name = "created_date")
    Date created_date;
    @Column(name = "imagen_url")
    String imagen_url;
    @Column(name = "termination_date")
    Date termination_date;
}
