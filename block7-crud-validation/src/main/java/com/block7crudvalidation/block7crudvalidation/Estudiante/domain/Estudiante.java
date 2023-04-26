package com.block7crudvalidation.block7crudvalidation.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "estudiantes")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id_Estudiante;
    @OneToOne
    @JoinColumn(name = "id_persona")
    Persona persona;
    @Column(name = "num_hours_week")
    Integer num_hours_week;
    @Column(name = "comments")
    String comments;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Profesor")
    Profesor profesor;
    @Column(name = "branch")
    String branch;
    @ManyToMany(mappedBy = "estudiante")
    List<Estudiante_Asignatura> estudios;

}
