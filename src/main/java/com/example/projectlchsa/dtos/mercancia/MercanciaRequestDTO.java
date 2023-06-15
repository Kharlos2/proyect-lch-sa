package com.example.projectlchsa.dtos.mercancia;

import java.time.LocalDate;

public class MercanciaRequestDTO {

    private String nombre;
    private String descripcion;
    private LocalDate fechaEntradaBodega;
    private String motivoDevolucion;
    private Double volumen;
    private Long idZona;

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

    public Long getIdZona() {
        return idZona;
    }

    public void setIdZona(Long idZona) {
        this.idZona = idZona;
    }
}
