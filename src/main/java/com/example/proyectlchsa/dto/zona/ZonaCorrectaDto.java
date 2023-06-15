package com.example.proyectlchsa.dto.zona;

import com.example.proyectlchsa.entities.MercanciaEntity;

import java.util.List;

public class ZonaCorrectaDto extends ZonaDto{

    private Long id;
    private Double espacioTotal;
    private Double espacioParcial;
    private List<MercanciaEntity> mercanciaEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getEspacioTotal() {
        return espacioTotal;
    }

    public void setEspacioTotal(Double espacioTotal) {
        this.espacioTotal = espacioTotal;
    }

    public Double getEspacioParcial() {
        return espacioParcial;
    }

    public void setEspacioParcial(Double espacioParcial) {
        this.espacioParcial = espacioParcial;
    }

    public List<MercanciaEntity> getMercanciaEntities() {
        return mercanciaEntities;
    }

    public void setMercanciaEntities(List<MercanciaEntity> mercanciaEntities) {
        this.mercanciaEntities = mercanciaEntities;
    }
}
