package com.block7crudvalidation.block7crudvalidation.Estudiante.domain;

import com.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto.EstudianteFullOutputDto;
import com.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto.EstudianteInputDto;
import com.block7crudvalidation.block7crudvalidation.Estudiante.controller.dto.EstudianteOutputDto;
import com.block7crudvalidation.block7crudvalidation.Asignatura.domain.Asignatura;
import com.block7crudvalidation.block7crudvalidation.Persona.domain.Persona;
import com.block7crudvalidation.block7crudvalidation.Profesor.domain.Profesor;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "estudiantes")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id_Estudiante;
    @OneToOne
    @JoinColumn(name = "id_persona", unique = true)
    Persona persona;
    @Column(name = "num_hours_week")
    int num_hours_week;
    @Column(name = "comments")
    String comments;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Profesor")
    Profesor profesor;
    @Column(name = "branch")
    String branch;
    @ManyToMany(mappedBy = "estudiantes")
    List<Asignatura> asignaturas;

    public Estudiante(EstudianteInputDto estudianteInputDto) {
        this.num_hours_week = estudianteInputDto.getNum_hours_week();
        this.comments = estudianteInputDto.getComments();
        this.branch = estudianteInputDto.getBranch();
        this.asignaturas = estudianteInputDto.getAsignaturas();
    }

    public EstudianteOutputDto estudianteToEstudianteOutputDto() {
        return new EstudianteOutputDto(
                this.id_Estudiante,
                this.persona.getId_persona(),
                this.num_hours_week,
                this.comments,
                this.branch,
                this.profesor.getId_Profesor(),
                this.asignaturas);
    }

    public EstudianteFullOutputDto estudianteToEstudianteFullOutputDto() {
        return new EstudianteFullOutputDto(
                this.id_Estudiante,
                this.num_hours_week,
                this.comments,
                this.profesor.getId_Profesor(),
                this.branch,
                this.asignaturas,
                this.persona.getId_persona(),
                this.persona.getUsuario(),
                this.persona.getPassword(),
                this.persona.getName(),
                this.persona.getSurname(),
                this.persona.getCompany_email(),
                this.persona.getPersonal_email(),
                this.persona.getCity(),
                this.persona.isActive(),
                this.persona.getCreated_date(),
                this.persona.getImagen_url(),
                this.persona.getTermination_date()
        );
    }
}
