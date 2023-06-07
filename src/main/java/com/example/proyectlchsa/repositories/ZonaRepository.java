package com.example.proyectlchsa.repositories;

import com.example.proyectlchsa.entities.Zona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZonaRepository extends JpaRepository<Zona, Long> {
}
