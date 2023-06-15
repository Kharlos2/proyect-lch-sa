package com.example.projectlchsa.repositories;

import com.example.projectlchsa.entities.MercanciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MercanciaRepository extends JpaRepository<MercanciaEntity, Long> {
}
