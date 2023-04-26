package com.block7crudvalidation.block7crudvalidation.repository;

import com.block7crudvalidation.block7crudvalidation.controller.dto.output.EstudianteOutputDto;
import com.block7crudvalidation.block7crudvalidation.domain.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer>, PagingAndSortingRepository<Estudiante, Integer> {

}
