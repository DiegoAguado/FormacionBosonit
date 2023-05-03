package com.block7crudvalidation.block7crudvalidation.Persona.domain;

import com.block7crudvalidation.block7crudvalidation.Asignatura.domain.Asignatura;
import com.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto.EstudianteFullOutputDto;
import com.block7crudvalidation.block7crudvalidation.Estudiante.domain.Estudiante;
import com.block7crudvalidation.block7crudvalidation.Persona.controller.dto.PersonaEstudianteOutputDto;
import com.block7crudvalidation.block7crudvalidation.Persona.controller.dto.PersonaInputDto;
import com.block7crudvalidation.block7crudvalidation.Persona.controller.dto.PersonaOutputDto;
import com.block7crudvalidation.block7crudvalidation.Persona.controller.dto.PersonaProfesorOutputDto;
import com.block7crudvalidation.block7crudvalidation.Profesor.domain.Profesor;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

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
    @OneToOne(mappedBy = "persona", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    Estudiante estudiante;
    @OneToOne(mappedBy = "persona", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    Profesor profesor;

    public PersonaOutputDto personaToPersonOutputDto() {
        return new PersonaOutputDto(
                this.id_persona,
                this.usuario,
                this.password,
                this.name,
                this.surname,
                this.company_email,
                this.personal_email,
                this.city,
                this.active,
                this.created_date,
                this.imagen_url,
                this.termination_date
        );
    }

    public Persona(PersonaInputDto personaInputDto) {
        this.usuario = personaInputDto.getUsuario();
        this.password = personaInputDto.getPassword();
        this.name = personaInputDto.getName();
        this.surname = personaInputDto.getSurname();
        this.company_email = personaInputDto.getCompany_email();
        this.personal_email = personaInputDto.getPersonal_email();
        this.city = personaInputDto.getCity();
        this.active = personaInputDto.isActive();
        this.created_date = personaInputDto.getCreated_date();
        this.imagen_url = personaInputDto.getImagen_url();
        this.termination_date = personaInputDto.getTermination_date();
    }

    public PersonaEstudianteOutputDto personaToPersonaEstudianteOutputDto() {
        return new PersonaEstudianteOutputDto(
                this.id_persona,
                this.usuario,
                this.password,
                this.name,
                this.surname,
                this.company_email,
                this.personal_email,
                this.city,
                this.active,
                this.created_date,
                this.imagen_url,
                this.termination_date,
                this.estudiante.estudianteToEstudianteOutputDto()
        );
    }

    public PersonaProfesorOutputDto personaToPersonaProfesorOutputDto() {
        return new PersonaProfesorOutputDto(
                this.id_persona,
                this.usuario,
                this.password,
                this.name,
                this.surname,
                this.company_email,
                this.personal_email,
                this.city,
                this.active,
                this.created_date,
                this.imagen_url,
                termination_date,
                this.profesor.profesorToProfesorOutputDto()
        );
    }
}
