package com.formacion.examen_JPA_cascada;

import com.formacion.examen_JPA_cascada.controller.Controller;
import com.formacion.examen_JPA_cascada.controller.dto.input.CabeceraFraInputDto;
import com.formacion.examen_JPA_cascada.controller.dto.input.ClienteInputDto;
import com.formacion.examen_JPA_cascada.controller.dto.input.LineasFraInputDto;
import com.formacion.examen_JPA_cascada.controller.dto.output.LineasFraOutputDto;
import com.formacion.examen_JPA_cascada.domain.*;
import com.formacion.examen_JPA_cascada.repository.CabeceraFraRepository;
import com.formacion.examen_JPA_cascada.repository.ClienteRepository;
import com.formacion.examen_JPA_cascada.repository.LineasFraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sound.sampled.Line;
import java.util.ArrayList;

@SpringBootApplication
public class ExamenJpaCascadaApplication  implements CommandLineRunner {
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	CabeceraFraRepository cabeceraFraRepository;
	@Autowired
	LineasFraRepository lineasFraRepository;

	public static void main(String[] args) {
		SpringApplication.run(ExamenJpaCascadaApplication.class, args);
	}

	@Override
	public void run(String... args)throws Exception{

		cabeceraFraRepository.save(
				new CabeceraFra(
						new CabeceraFraInputDto(clienteRepository.save(
								new Cliente(
										new ClienteInputDto("Diego", cabeceraFraRepository.findAll()))), 0.0, lineasFraRepository.findById(1).stream().toList())));
		lineasFraRepository.save(new LineasFra(new LineasFraInputDto(1,"casco",0,0)));
	}
}
