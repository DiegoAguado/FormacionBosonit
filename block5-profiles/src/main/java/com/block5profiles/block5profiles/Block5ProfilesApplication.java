package com.block5profiles.block5profiles;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Block5ProfilesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Block5ProfilesApplication.class, args);
	}

	@Value("${spring.profiles.active}")
	private String helloworld;

	@Value("${bd.url}")
	private int number;


	@Override
	public void run(String... args) throws Exception {
		System.out.println("El valor de greeting es: "+helloworld);
		System.out.println("El valor de my.number es: "+number);
	}
}
