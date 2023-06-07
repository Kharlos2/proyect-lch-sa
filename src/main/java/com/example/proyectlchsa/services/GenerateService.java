package com.example.proyectlchsa.services;

import java.util.List;

public interface GenerateService<E> {

    List<E> findAll();

    E findObject(Long idObject);

    E saveObject(E object);

    E updateObject(Long idObject, E object);

    boolean deleteObject(Long idObject);
}
