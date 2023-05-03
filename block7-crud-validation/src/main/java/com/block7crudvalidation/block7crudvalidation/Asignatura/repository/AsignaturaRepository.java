package com.block7crudvalidation.block7crudvalidation.Asignatura.repository;

import com.block7crudvalidation.block7crudvalidation.Asignatura.domain.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Integer>, PagingAndSortingRepository<Asignatura, Integer> {
    @Query(value = "SELECT * FROM Estudios as E LEFT JOIN Estudiantes as ES ON E.estudiantes = ES.id_Estudiante WHERE ES.id_Estudiante = ?1", nativeQuery = true)
    List<Asignatura> getByEstudiante(int id_Estudiante);
}