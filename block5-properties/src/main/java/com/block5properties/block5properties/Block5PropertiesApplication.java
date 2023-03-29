package com.block5properties.block5properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Block5PropertiesApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Block5PropertiesApplication.class, args);
    }

    @Value("${greeting}")
    private String helloworld;

    @Value("${my.number}")
    private int number;

    @Value("${new.property:new.property no tiene valor}")
    private String property;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("El valor de greeting es: "+helloworld);
        System.out.println("El valor de my.number es: "+number);
        System.out.println("El valor de new.property es: "+property);
    }
}
