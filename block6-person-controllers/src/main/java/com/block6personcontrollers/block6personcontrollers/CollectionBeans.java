package com.block6personcontrollers.block6personcontrollers;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Data
public class CollectionBeans {

    public Persona p = new Persona();
    public ArrayList<Ciudad> ciudades = new ArrayList<>();

    @Bean
    Persona returnPersona(){
        return p;
    }

    @Bean
    ArrayList<Ciudad> returnCiudades(){
        return ciudades;
    }

    @Bean
    Persona returnP1(){
        Persona p1 = new Persona();
        p1.setNombre("A");
        return p1;
    }

    @Bean
    Persona returnP2(){
        Persona p2 = new Persona();
        p2.setNombre("B");
        return p2;
    }

    @Bean
    Persona returnP3(){
        Persona p3 = new Persona();
        p3.setNombre("C");
        return p3;
    }
}
