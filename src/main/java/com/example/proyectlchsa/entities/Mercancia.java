package com.example.proyectlchsa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "mercancia")
public class Mercancia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iup")
    private Long iup;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @Column(name = "fechaEntradaBodega", nullable = false)
    private LocalDate fechaEntradaBodega;
    @Column(name = "motivoDevolucion", nullable = false)
    private String motivoDevolucion;
    @Column(name = "volumen", nullable = false)
    private Double volumen;


}
