package com.block7crudvalidation.block7crudvalidation.Asignatura.domain;

import com.block7crudvalidation.block7crudvalidation.Asignatura.controller.dto.AsignaturaInputDto;
import com.block7crudvalidation.block7crudvalidation.Asignatura.controller.dto.AsignaturaOutputDto;
import com.block7crudvalidation.block7crudvalidation.Estudiante.domain.Estudiante;
import com.block7crudvalidation.block7crudvalidation.Profesor.domain.Profesor;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "estudios")
@NoArgsConstructor
@AllArgsConstructor
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id_asignatura;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Profesor")
    Profesor profesor;
    @ManyToMany(cascade = CascadeType.ALL)
    List<Estudiante> estudiantes;
    @Column(name = "asignatura")
    String asignatura;
    @Column(name = "comentarios")
    String comentarios;
    @Column(name = "initial_date")
    Date initial_date;
    @Column(name = "finish_date")
    Date finish_date;

    public Asignatura(AsignaturaInputDto asignaturaInputDto) {
        this.profesor.setId_Profesor(asignaturaInputDto.getId_Profesor());
        this.asignatura = asignaturaInputDto.getAsignatura();
        this.comentarios = asignaturaInputDto.getComentarios();
        this.initial_date = asignaturaInputDto.getInitial_date();
        this.finish_date = asignaturaInputDto.getFinish_date();
    }

    public AsignaturaOutputDto asignaturaToAsignaturaOutputDto() {
        return new AsignaturaOutputDto(
                this.id_asignatura,
                this.profesor,
                this.estudiantes,
                this.asignatura,
                this.comentarios,
                this.initial_date,
                this.finish_date
        );
    }
}
