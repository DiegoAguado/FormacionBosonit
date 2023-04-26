package com.block7crudvalidation.block7crudvalidation.repository;

import com.block7crudvalidation.block7crudvalidation.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProfesorRepository extends JpaRepository<Profesor, Integer>, PagingAndSortingRepository<Profesor, Integer> {

}
