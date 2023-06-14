package com.example.proyectlchsa.dto;

import com.example.proyectlchsa.entities.Zona;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public class MercanciaCorrectaDto extends MercanciaDto{
    private Long iup;
    private String nombre;
    private String descripcion;
    private LocalDate fechaEntradaBodega;
    private String motivoDevolucion;
    private Double volumen;
    private Zona zona;
}
