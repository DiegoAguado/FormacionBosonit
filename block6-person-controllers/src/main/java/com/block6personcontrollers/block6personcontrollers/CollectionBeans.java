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
    public Persona p1 = new Persona();
    public Persona p2 = new Persona();
    public Persona p3 = new Persona();

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
        p1.setNombre("A");
        return p1;
    }

    @Bean
    Persona returnP2(){
        p2.setNombre("A");
        return p2;
    }

    @Bean
    Persona returnP3(){
        p3.setNombre("A");
        return p3;
    }
}
