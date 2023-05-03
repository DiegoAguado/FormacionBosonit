package com.block7crudvalidation.block7crudvalidation.Profesor.domain;

import com.block7crudvalidation.block7crudvalidation.Persona.domain.Persona;
import com.block7crudvalidation.block7crudvalidation.Profesor.controller.dto.ProfesorFullOutputDto;
import com.block7crudvalidation.block7crudvalidation.Profesor.controller.dto.ProfesorInputDto;
import com.block7crudvalidation.block7crudvalidation.Profesor.controller.dto.ProfesorOutputDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "profesores")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id_Profesor;
    @OneToOne
    @JoinColumn(name = "id_persona", unique = true)
    Persona persona;
    /*@OneToMany(mappedBy = "profesor")
    Set<Estudiante> estudiantes;*/
    @Column(name = "comments")
    String comments;
    @Column(name = "branch")
    String branch;

    public Profesor(ProfesorInputDto profesorInputDto) {
        this.id_Profesor = profesorInputDto.getId_Profesor();
        this.comments = profesorInputDto.getComments();
        this.branch = profesorInputDto.getBranch();
    }
    public ProfesorOutputDto profesorToProfesorOutputDto() {
        return new ProfesorOutputDto(
                this.id_Profesor,
                this.persona.getId_persona(),
                this.comments,
                this.branch);
    }

    public ProfesorFullOutputDto profesorToProfesorFullOutputDto() {
        return new ProfesorFullOutputDto(
                this.id_Profesor,
                this.persona.getId_persona(),
                this.comments,
                this.branch,
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
