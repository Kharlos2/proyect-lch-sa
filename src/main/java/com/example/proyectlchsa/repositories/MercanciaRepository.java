package com.example.proyectlchsa.repositories;

import com.example.proyectlchsa.entities.MercanciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MercanciaRepository extends JpaRepository<MercanciaEntity, Long> {
}
