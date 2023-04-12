package com.block6personcontrollers.block6personcontrollers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class Block6PersonControllersApplication {

	@Bean
	Persona bean1(){
		var bean1 = new Persona();
		bean1.setNombre("A");
		return bean1;
	}

	@Bean
	Persona bean2(){
		var bean2 = new Persona();
		bean2.setNombre("B");
		return bean2;
	}

	@Bean
	Persona bean3(){
		var bean3 = new Persona();
		bean3.setNombre("C");
		return bean3;
	}
	public static void main(String[] args) {
		SpringApplication.run(Block6PersonControllersApplication.class, args);
	}
}
