package com.formacion.examen_JPA_cascada.domain;

import com.formacion.examen_JPA_cascada.controller.dto.input.LineasFraInputDto;
import com.formacion.examen_JPA_cascada.controller.dto.output.LineasFraOutputDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lineasFra")
public class LineasFra {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @ManyToOne
    @JoinColumn(name = "cabeceras", nullable = false, unique = true)
    private CabeceraFra idFra;
    @Column(nullable = false)
    private String proNomb;
    @Column
    private double cantidad;
    @Column
    private double precio;

    public LineasFraOutputDto lineasFraToLineasFraOutputDto() {
        return new LineasFraOutputDto(this.idFra.getId(),this.proNomb,this.cantidad,this.precio);
    }

    public LineasFra(LineasFraInputDto lineasFraInputDto){
        this.idFra = lineasFraInputDto.getIdFra();
        this.proNomb = lineasFraInputDto.getProNomb();
        this.cantidad = lineasFraInputDto.getCantidad();
        this.precio = lineasFraInputDto.getPrecio();
    }
}
