package com.block7crudvalidation.block7crudvalidation.Estudiante.repository;

import com.block7crudvalidation.block7crudvalidation.Estudiante.domain.Estudiante;
import com.block7crudvalidation.block7crudvalidation.Persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer>, PagingAndSortingRepository<Estudiante, Integer> {
    @Query(value = "SELECT * FROM Estudiantes WHERE id_Estudiante = ?1", nativeQuery = true)
    Optional<Estudiante> getEstudianteById(int id_Estudiante);

    @Query(value = "SELECT * FROM Estudiantes WHERE id_Persona = ?1", nativeQuery = true)
    Optional<Estudiante> getEstudianteById_Persona(int id_Persona);
}
