package com.block7crudvalidation.block7crudvalidation.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "profesores")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    String id_Profesor;
    @OneToOne
    @JoinColumn(name = "id_Persona")
    Persona persona;
    @OneToMany(mappedBy = "profesor")
    Set<Estudiante> estudiantes;
    @Column(name = "comments")
    String comments;
    @Column(name = "branch")
    String branch;
}
