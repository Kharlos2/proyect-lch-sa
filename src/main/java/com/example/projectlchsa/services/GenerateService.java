package com.example.projectlchsa.services;

import java.util.List;

public interface GenerateService<E,T> {

    List<E> findAll() throws Exception;

    E findObject(Long idObject) throws Exception;

    E saveObject(T object) throws Exception;

    E updateObject(Long idObject, T object) throws Exception;

    boolean deleteObject(Long idObject) throws Exception;
}
