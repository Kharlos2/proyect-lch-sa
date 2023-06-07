package com.example.proyectlchsa.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "zona")
public class Zona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "espacio_total", nullable = false)
    private Double espacioTotal;
    @Column(name = "espacio_parcial", nullable = false)
    private Double espacioParcial;
    @OneToMany(mappedBy = "zona", cascade = CascadeType.ALL)
    @Column(name = "mercancias", nullable = false)
    @JsonBackReference
    private List<Mercancia> mercancias;
}
