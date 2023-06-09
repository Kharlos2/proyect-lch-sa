package com.example.proyectlchsa.services;

import com.example.proyectlchsa.entities.Zona;
import com.example.proyectlchsa.repositories.ZonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZonaService implements GenerateService<Zona> {

    @Autowired
    private ZonaRepository zonaRepository;

    @Override
    public List<Zona> findAll() throws Exception {
        try {
            return zonaRepository.findAll();
        } catch (Exception e) {
            throw new Exception("No se lograron traer los resgistros de Zona.");
        }
    }

    @Override
    public Zona findObject(Long idObject) throws Exception {
        try {
            Optional<Zona> zona = zonaRepository.findById(idObject);
            if (zona.isPresent()) {
                return zona.get();
            }else {
                throw new Exception("No se encontró el id ingresado.");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Zona saveObject(Zona object) throws Exception {
        try {
            if (object.getEspacioParcial() == null) {
                throw new Exception("El espacio parcial debe ser ingresado.");
            } else if (object.getEspacioTotal() == null) {
                throw new Exception("El espacio total debe ser ingresado.");
            }else {
                return zonaRepository.save(object);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Zona updateObject(Long idObject, Zona object) throws Exception {
        try {
            Optional<Zona> zona = zonaRepository.findById(idObject);
            if (zona.isEmpty()) {
                throw new Exception("No se encontró el id ingresado.");
            }else {
                if (object.getEspacioParcial() == null) {
                    throw new Exception("El espacio parcial debe ser ingresado.");
                } else if (object.getEspacioTotal() == null) {
                    throw new Exception("El espacio total debe ser ingresado.");
                }
                else {
                    return zonaRepository.save(object);
                }
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean deleteObject(Long idObject) throws Exception {
        try {
            Optional<Zona> zona = zonaRepository.findById(idObject);
            if (zona.isPresent()){
                zonaRepository.deleteById(idObject);
                return true;
            }
            else{
                throw new Exception("No se encontro el objeto con ese id.");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
