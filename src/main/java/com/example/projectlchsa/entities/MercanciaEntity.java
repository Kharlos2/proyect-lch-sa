package com.example.projectlchsa.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "mercancia")
public class MercanciaEntity {

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
    private ZonaEntity zona;

    public Long getIup() {
        return iup;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFechaEntradaBodega() {
        return fechaEntradaBodega;
    }

    public String getMotivoDevolucion() {
        return motivoDevolucion;
    }

    public Double getVolumen() {
        return volumen;
    }

    public ZonaEntity getZona() {
        return zona;
    }
}
