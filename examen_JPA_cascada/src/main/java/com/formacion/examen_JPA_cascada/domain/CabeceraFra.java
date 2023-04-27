package com.formacion.examen_JPA_cascada.domain;

import com.formacion.examen_JPA_cascada.controller.dto.input.CabeceraFraInputDto;
import com.formacion.examen_JPA_cascada.controller.dto.output.CabeceraFraOutputDto;
import com.formacion.examen_JPA_cascada.controller.dto.output.LineasFraOutputDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cabeceras")
public class CabeceraFra {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @ManyToOne
    @JoinColumn(name = "cliente", nullable = false, unique = true)
    private Cliente cli_codi;
    @Column
    private double importeFra;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "idFra")
    private List<LineasFra> lineas;

    public CabeceraFraOutputDto cabeceraFraToCabeceraFraOutputDto(){
        return new CabeceraFraOutputDto(
                this.id, this.cli_codi.clienteToClienteOutputDto(), this.importeFra, this.lineas.stream().map(LineasFra::lineasFraToLineasFraOutputDto).toList());
    }

    public CabeceraFra(CabeceraFraInputDto cabeceraFraInputDto){
        this.importeFra = cabeceraFraInputDto.getImporteFra();
        this.lineas = cabeceraFraInputDto.getLineas();
        this.cli_codi = cabeceraFraInputDto.getCli_codi();
    }

    public void addLineas(LineasFra lineasFra) {
        this.lineas.add(lineasFra);
    }
}
