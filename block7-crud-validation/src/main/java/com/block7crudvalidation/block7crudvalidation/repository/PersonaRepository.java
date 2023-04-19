package com.block7crudvalidation.block7crudvalidation.repository;

import com.block7crudvalidation.block7crudvalidation.controller.dto.PersonaOutputDto;
import com.block7crudvalidation.block7crudvalidation.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    List<Persona> findByUsuarioLike(String usuario);
}
