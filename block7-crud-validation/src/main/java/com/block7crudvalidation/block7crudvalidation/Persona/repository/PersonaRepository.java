package com.block7crudvalidation.block7crudvalidation.Persona.repository;

import com.block7crudvalidation.block7crudvalidation.Estudiante.domain.Estudiante;
import com.block7crudvalidation.block7crudvalidation.Persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona, Integer>, PagingAndSortingRepository<Persona, Integer> {
    List<Persona> findByUsuarioLike(String usuario);

    @Query(value = "SELECT P.* FROM Personas as P LEFT JOIN Estudiantes as E ON P.id_persona = E.id_persona WHERE P.id_persona = ?1", nativeQuery = true)
    Persona getPersonaEstudiante(int id_Persona);

    @Query(value = "SELECT P.* FROM Personas as P LEFT JOIN Profesores as E ON P.id_persona = E.id_persona WHERE P.id_persona = ?1", nativeQuery = true)
    Persona getPersonaProfesor(int id_Persona);
}
