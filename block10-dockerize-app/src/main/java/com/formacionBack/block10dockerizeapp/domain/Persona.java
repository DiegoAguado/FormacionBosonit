package com.formacionBack.block10dockerizeapp.domain;

import com.formacionBack.block10dockerizeapp.controller.dto.PersonaInputDto;
import com.formacionBack.block10dockerizeapp.controller.dto.PersonaOutputDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    @Id
    @GeneratedValue
    int id;
    String nombre;
    String edad;
    String poblacion;

    public Persona(PersonaInputDto personaInputDto){
        this.nombre=personaInputDto.getNombre();
        this.edad=personaInputDto.getEdad();
        this.poblacion= personaInputDto.getPoblacion();
    }

    public PersonaOutputDto personaToPersonaOutputDto(){
        return new PersonaOutputDto(this.id, this.nombre, this.edad, this.poblacion);
    }
}
