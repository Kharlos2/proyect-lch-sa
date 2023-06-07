package com.example.proyectlchsa.services;

import java.util.List;

public interface GenerateService<E> {

    List<E> findAll() throws Exception;

    E findObject(Long idObject) throws Exception;

    E saveObject(E object) throws Exception;

    E updateObject(Long idObject, E object) throws Exception;

    boolean deleteObject(Long idObject) throws Exception;
}
