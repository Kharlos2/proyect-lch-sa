package com.example.proyectlchsa.services;

import com.example.proyectlchsa.entities.Mercancia;
import com.example.proyectlchsa.repositories.MercanciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        try{
            Optional<Mercancia> mercancia = mercanciaRepository.findById(idObject);
            if (mercancia.isPresent()){
                return mercancia.get();
            }else {
                throw new Exception("No se encontró el id ingresado.");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Mercancia saveObject(Mercancia object) throws Exception {
        try {
            if (object.getNombre()==null){
                throw new Exception("Debe ingresar un nombre");
            }
            else if (object.getDescripcion()==null){
                throw new Exception("Debe ingresar la descripcion");
            }
            else if (object.getFechaEntradaBodega()==null){
                throw new Exception("Debe ingresar la fecha de entrega");
            }
            else if (object.getMotivoDevolucion()==null){
                throw new Exception("Debe ingresar un motivo de devolucion");
            }
            else if (object.getVolumen()==null){
                throw new Exception("Debe ingresar el volumen");
            }
            else {
                return mercanciaRepository.save(object);
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }

    @Override
    public Mercancia updateObject(Long idObject, Mercancia object) throws Exception {
        try {
            Optional<Mercancia> mercancia = mercanciaRepository.findById(idObject);
            if (mercancia.isEmpty()){
                throw new Exception("No se encontró el id ingresado.");
            }else {
                if (object.getNombre()==null){
                    throw new Exception("Debe ingresar un nombre");
                }
                else if (object.getDescripcion()==null){
                    throw new Exception("Debe ingresar la descripcion");
                }
                else if (object.getFechaEntradaBodega()==null){
                    throw new Exception("Debe ingresar la fecha de entrega");
                }
                else if (object.getMotivoDevolucion()==null){
                    throw new Exception("Debe ingresar un motivo de devolucion");
                }
                else if (object.getVolumen()==null){
                    throw new Exception("Debe ingresar el volumen");
                }
                else {
                    return mercanciaRepository.save(object);
                }
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public boolean deleteObject(Long idObject) throws Exception {
        try {
            Optional<Mercancia> mercancia = mercanciaRepository.findById(idObject);
            if (mercancia.isPresent()){
                mercanciaRepository.deleteById(idObject);
                return true;
            }
            else {
                throw new Exception("No se encontro el objeto con ese id.");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
