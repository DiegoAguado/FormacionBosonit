package com.block6personcontrollers.block6personcontrollers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@SpringBootApplication
@Slf4j
public class Block6PersonControllersApplication {

	@Autowired
	Controlador1 controlador1;
	public static void main(String[] args) {
		SpringApplication.run(Block6PersonControllersApplication.class, args);
	}
}
