package com.example.proyectlchsa.dto.mercancia;

import com.example.proyectlchsa.entities.ZonaEntity;
import java.time.LocalDate;

public class MercanciaCorrectaDto extends MercanciaDto{
    private Long iup;
    private String nombre;
    private String descripcion;
    private LocalDate fechaEntradaBodega;
    private String motivoDevolucion;
    private Double volumen;
    private ZonaEntity zona;

    public Long getIup() {
        return iup;
    }

    public void setIup(Long iup) {
        this.iup = iup;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaEntradaBodega() {
        return fechaEntradaBodega;
    }

    public void setFechaEntradaBodega(LocalDate fechaEntradaBodega) {
        this.fechaEntradaBodega = fechaEntradaBodega;
    }

    public String getMotivoDevolucion() {
        return motivoDevolucion;
    }

    public void setMotivoDevolucion(String motivoDevolucion) {
        this.motivoDevolucion = motivoDevolucion;
    }

    public Double getVolumen() {
        return volumen;
    }

    public void setVolumen(Double volumen) {
        this.volumen = volumen;
    }

    public ZonaEntity getZonaEntity() {
        return zona;
    }

    public void setZonaEntity(ZonaEntity zona) {
        this.zona = zona;
    }
}
