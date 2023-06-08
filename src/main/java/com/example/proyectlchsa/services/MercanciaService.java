package com.example.proyectlchsa.services;

import com.example.proyectlchsa.entities.Mercancia;
import com.example.proyectlchsa.repositories.MercanciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MercanciaService implements GenerateService<Mercancia> {

    @Autowired
    private MercanciaRepository mercanciaRepository;


    @Override
    public List<Mercancia> findAll() throws Exception {
        try {
            return mercanciaRepository.findAll();
        } catch (Exception e) {
            throw new Exception("No se lograron traer los resgistros de Mercancía.");
        }
    }

    @Override
    public Mercancia findObject(Long idObject) throws Exception {
        return null;
    }

    @Override
    public Mercancia saveObject(Mercancia object) throws Exception {
        return null;
    }

    @Override
    public Mercancia updateObject(Long idObject, Mercancia object) throws Exception {
        return null;
    }

    @Override
    public boolean deleteObject(Long idObject) throws Exception {
        return false;
    }
}
