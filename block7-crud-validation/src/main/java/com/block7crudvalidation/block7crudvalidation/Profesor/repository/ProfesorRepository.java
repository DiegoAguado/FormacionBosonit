package com.block7crudvalidation.block7crudvalidation.Profesor.repository;

import com.block7crudvalidation.block7crudvalidation.Estudiante.domain.Estudiante;
import com.block7crudvalidation.block7crudvalidation.Profesor.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ProfesorRepository extends JpaRepository<Profesor, Integer>, PagingAndSortingRepository<Profesor, Integer> {
    @Query(value = "SELECT * FROM Profesores WHERE id_Profesor = ?1", nativeQuery = true)
    Optional<Profesor> getProfesorById(int id_Profesor);

    @Query(value = "SELECT * FROM Profesores WHERE id_Persona = ?1", nativeQuery = true)
    Optional<Profesor> getProfesorById_Persona(int id_Persona);
}
