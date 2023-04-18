package block7crud.block7crud.repository;

import block7crud.block7crud.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, String>{
    List<Persona> findByNombreLike(String nombre);
}
