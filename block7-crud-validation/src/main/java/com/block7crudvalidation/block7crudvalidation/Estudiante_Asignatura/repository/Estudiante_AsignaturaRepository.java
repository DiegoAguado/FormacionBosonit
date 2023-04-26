package com.block7crudvalidation.block7crudvalidation.repository;

import com.block7crudvalidation.block7crudvalidation.domain.Estudiante_Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface Estudiante_AsignaturaRepository extends JpaRepository<Estudiante_Asignatura, Integer>, PagingAndSortingRepository<Estudiante_Asignatura, Integer> {

}