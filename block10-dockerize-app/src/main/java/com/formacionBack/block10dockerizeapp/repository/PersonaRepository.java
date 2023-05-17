package com.formacionBack.block10dockerizeapp.repository;


import com.formacionBack.block10dockerizeapp.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, String> {
    List<Persona> findByNombreLike(String nombre);
}
