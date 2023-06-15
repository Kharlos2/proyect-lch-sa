package com.example.projectlchsa.dtos.mercancia;

import com.example.projectlchsa.entities.ZonaEntity;
import java.time.LocalDate;

public class MercanciaCorrectoDTO extends MercanciaDTO {

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

    public ZonaEntity getZona() {
        return zona;
    }

    public void setZona(ZonaEntity zona) {
        this.zona = zona;
    }
}
