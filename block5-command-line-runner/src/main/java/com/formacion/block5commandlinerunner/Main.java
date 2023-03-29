package com.formacion.block5commandlinerunner;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
	@PostConstruct
	void primeraClase(){
		System.out.println("Hola desde clase inicial");
	}

	@Bean
	CommandLineRunner claseSecundaria()
	{
		return p ->System.out.println("Hola desde clase secundaria");
	}
	@Bean
	CommandLineRunner terceraClase()
	{
		primeraClase();
		return p ->claseSecundaria();
	}


	@Override
	public void run(String... args) throws Exception {

	}
}
