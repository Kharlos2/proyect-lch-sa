package com.example.projectlchsa.repositories;

import com.example.projectlchsa.entities.ZonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZonaRepository extends JpaRepository<ZonaEntity, Long> {
}
