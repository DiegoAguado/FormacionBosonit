package com.block7crudvalidation.block7crudvalidation.repository;

import com.block7crudvalidation.block7crudvalidation.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface PersonaRepository extends JpaRepository<Persona, Integer>, PagingAndSortingRepository<Persona, Integer> {
    List<Persona> findByUsuarioLike(String usuario);
}
