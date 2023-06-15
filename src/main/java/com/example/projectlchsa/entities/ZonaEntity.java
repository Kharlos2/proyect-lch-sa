package com.example.projectlchsa.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "zona")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class ZonaEntity {

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
    @JsonManagedReference
    @JsonIgnore
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

    @Override
    public String toString() {
        return "ZonaEntity{" +
                "id=" + id +
                ", espacioTotal=" + espacioTotal +
                ", espacioParcial=" + espacioParcial +
                ", mercanciaEntities=" + mercanciaEntities +
                '}';
    }
}
