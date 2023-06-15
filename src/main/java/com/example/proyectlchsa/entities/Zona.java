package com.example.proyectlchsa.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "zona")
public class Zona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_zona")
    private Long id;
    @Column(name = "espacio_total", nullable = false)
    private Double espacioTotal;
    @Column(name = "espacio_parcial", nullable = false)
    private Double espacioParcial;
    @OneToMany(mappedBy = "zona", cascade = CascadeType.ALL)
    @Column(name = "mercancias", nullable = false)
    @JsonBackReference
    private List<Mercancia> mercancias;

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

    public List<Mercancia> getMercancias() {
        return mercancias;
    }

    public void setMercancias(List<Mercancia> mercancias) {
        this.mercancias = mercancias;
    }
}
