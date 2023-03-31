package com.block6simplecontrollers.block6simplecontrollers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@SpringBootApplication
@RestController
public class Block6SimpleControllersApplication {

	public static void main(String[] args) {
		SpringApplication.run(Block6SimpleControllersApplication.class, args);
	}

	@GetMapping(value = "/user/{nombre}")
	public String usuario(@PathVariable String nombre){
		return "Hola " + nombre;
	}

	@PostMapping(value = "/useradd")
	public Persona usuario2(@RequestBody Persona persona){
		persona.setEdad(persona.getEdad()+1);
		return persona;
	}
}
