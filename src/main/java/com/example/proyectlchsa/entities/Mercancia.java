package com.example.proyectlchsa.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @Column(name = "fecha_entrada_bodega", nullable = false)
    private LocalDate fechaEntradaBodega;
    @Column(name = "motivo_devolucion", nullable = false)
    private String motivoDevolucion;
    @Column(name = "volumen", nullable = false)
    private Double volumen;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "zona", nullable = false)
    @JsonManagedReference
    private Zona zona;
}
