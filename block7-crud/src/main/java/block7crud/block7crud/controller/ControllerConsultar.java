package block7crud.block7crud.controller;

import block7crud.block7crud.application.PersonaServiceImpl;
import block7crud.block7crud.controller.dto.PersonaOutputDto;
import block7crud.block7crud.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class ControllerConsultar {
    @Autowired
    PersonaServiceImpl personaService;

    @GetMapping("/{id}")
    public ResponseEntity<PersonaOutputDto> getPersonaById(@PathVariable String id){
        try{
            return ResponseEntity.ok().body(personaService.getPersonaById(id));
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/nombre/{nombre}")
    public List<Persona> getPersonasByNombre(@PathVariable String nombre){
        return personaService.getPersonasByNombre(nombre);
    }

    @GetMapping
    public List<Persona> getPersonas(){
        return personaService.getPersonas();
    }
}
