package com.block7crudvalidation.block7crudvalidation.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "estudios")
public class Estudiante_Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id_asignatura;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Profesor")
    Profesor profesor;
    @ManyToMany(cascade = CascadeType.ALL)
    List<Estudiante> estudiante;
    @Column(name = "asignatura")
    String asignatura;
    @Column(name = "comentarios")
    String comentarios;
    @Column(name = "initial_date")
    Date initial_date;
    @Column(name = "finish_date")
    Date finish_date;
}
