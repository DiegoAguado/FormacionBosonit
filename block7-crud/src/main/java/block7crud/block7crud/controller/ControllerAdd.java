package block7crud.block7crud.controller;

import block7crud.block7crud.application.PersonaServiceImpl;
import block7crud.block7crud.controller.dto.PersonaInputDto;
import block7crud.block7crud.controller.dto.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/persona")
public class ControllerAdd {
    @Autowired
    PersonaServiceImpl personaService;

    @PostMapping
    public ResponseEntity<PersonaOutputDto> addPersona(@RequestBody PersonaInputDto personaInputDto){
        URI location = URI.create("/persona");
        return ResponseEntity.created(location).body(personaService.addPersona(personaInputDto));
    }
}
