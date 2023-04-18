package block7crud.block7crud.controller;

import block7crud.block7crud.application.PersonaServiceImpl;
import block7crud.block7crud.controller.dto.PersonaInputDto;
import block7crud.block7crud.controller.dto.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class ControllerUpdate {
    @Autowired
    PersonaServiceImpl personaService;
    @PutMapping("/{id}")
    public ResponseEntity<PersonaOutputDto> updatePersona(@PathVariable String id, @RequestBody PersonaInputDto personaInputDto){
        try{
            return ResponseEntity.ok().body(personaService.updatePersona(id, personaInputDto));
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
