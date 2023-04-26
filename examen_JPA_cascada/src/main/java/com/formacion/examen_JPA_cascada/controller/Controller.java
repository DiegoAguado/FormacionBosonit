package com.formacion.examen_JPA_cascada.controller;

import com.formacion.examen_JPA_cascada.application.*;
import com.formacion.examen_JPA_cascada.controller.dto.input.LineasFraInputDto;
import com.formacion.examen_JPA_cascada.controller.dto.output.CabeceraFraOutputDto;
import com.formacion.examen_JPA_cascada.controller.dto.output.ClienteOutputDto;
import com.formacion.examen_JPA_cascada.controller.dto.output.LineasFraOutputDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/factura")
public class Controller {
    @Autowired
    CabeceraFraServiceImpl cabeceraFraService;
    @Autowired
    LineasFraServiceImpl lineasFraService;
    @GetMapping
    public ResponseEntity<List<CabeceraFraOutputDto>> getFacturas(){
        return ResponseEntity.ok(cabeceraFraService.getAllFacturas());
    }

    @GetMapping(value = "/lineas")
    public ResponseEntity<List<LineasFraOutputDto>> getLineas(){
        return ResponseEntity.ok(lineasFraService.getAllLineas());
    }

    @DeleteMapping(value = "/{idFra}")
    public ResponseEntity<CabeceraFraOutputDto> deleteFactura(@PathVariable int idFra)throws EntityNotFoundException {
        try{
            cabeceraFraService.deleteFactura(idFra);
            return ResponseEntity.ok().build();
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/linea/{idFra}")
    public ResponseEntity<CabeceraFraOutputDto> updateFactura(@PathVariable int idFra, @RequestBody LineasFraInputDto lineasFraInputDto) throws EntityNotFoundException{
        try{
            return ResponseEntity.ok().body(cabeceraFraService.updateFactura(idFra, lineasFraInputDto));
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
