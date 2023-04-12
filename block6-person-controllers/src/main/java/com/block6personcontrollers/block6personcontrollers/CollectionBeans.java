package com.block6personcontrollers.block6personcontrollers;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Data
public class CollectionBeans {

    public Persona persona = new Persona();
    public ArrayList<Ciudad> ciudades = new ArrayList<>();

    Persona returnPersona(){
        return persona;
    }

    ArrayList<Ciudad> returnCiudades(){
        return ciudades;
    }
}
