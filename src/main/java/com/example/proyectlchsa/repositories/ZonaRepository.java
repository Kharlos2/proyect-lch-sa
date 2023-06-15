package com.example.proyectlchsa.repositories;

import com.example.proyectlchsa.entities.ZonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZonaRepository extends JpaRepository<ZonaEntity, Long> {
}
