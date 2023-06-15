package com.example.projectlchsa.services;

import com.example.projectlchsa.dtos.mercancia.MercanciaCorrectoDTO;
import com.example.projectlchsa.dtos.mercancia.MercanciaRequestDTO;
import com.example.projectlchsa.entities.MercanciaEntity;
import com.example.projectlchsa.entities.ZonaEntity;
import com.example.projectlchsa.mappers.MercanciaMapper;
import com.example.projectlchsa.repositories.MercanciaRepository;
import com.example.projectlchsa.repositories.ZonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MercanciaService implements GenerateService<MercanciaCorrectoDTO, MercanciaRequestDTO> {

    @Autowired
    private MercanciaRepository mercanciaRepository;
    @Autowired
    private ZonaRepository zonaRepository;
    @Autowired
    private MercanciaMapper mapper;

    @Override
    public List<MercanciaCorrectoDTO> findAll() throws Exception {
        try {
            return mapper.mercanciasCorrectasDTOs(mercanciaRepository.findAll());
        } catch (Exception e) {
            throw new Exception("No se lograron traer los registros de Mercancia.");
        }
    }

    @Override
    public MercanciaCorrectoDTO findObject(Long idObject) throws Exception {
        try {
            Optional<MercanciaEntity> mercancia = mercanciaRepository.findById(idObject);
            if (mercancia.isPresent()) {
                return mapper.mercanciaCorrectaDTO(mercancia.get());
            } else throw new Exception("No se encontró el id ingresado.");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public MercanciaCorrectoDTO saveObject(MercanciaRequestDTO object) throws Exception {
        try {
            MercanciaEntity mercancia = mapper.mercanciaEntidadRequest(object);
            System.out.println(mercancia);
            if (mercancia.getNombre() == null || object.getNombre().length() == 0) {
                throw new Exception("El nombre debe ser ingresado y no puede estar vacío.");
            } else if (mercancia.getDescripcion() == null || object.getDescripcion().length() == 0) {
                throw new Exception("La descripción debe ser ingresada y no puede estar vacío.");
            } else if (mercancia.getFechaEntradaBodega() == null) {
                throw new Exception("La fecha de entrada a bodega debe ser ingresada.");
            } else if (mercancia.getMotivoDevolucion() == null || object.getMotivoDevolucion().length() == 0) {
                throw new Exception("El motivo de devolución debe ser ingresado y no puede estar vacío.");
            } else if (object.getIdZona() == null || object.getIdZona() == 0) {
                throw new Exception("El id de la zona debe ser ingresado.");
            } else if (mercancia.getVolumen() == null || object.getVolumen() == 0) {
                throw new Exception("El volumen debe ser ingresado y no puede ser 0.");
            } else {
                Optional<ZonaEntity> zona = zonaRepository.findById(object.getIdZona());
                if (zona.isPresent()) {
                    ZonaEntity zonaEntity = zona.get();
                    if (zonaEntity.getEspacioParcial() + mercancia.getVolumen() > zonaEntity.getEspacioTotal()) {
                        throw new Exception("El volumen se pasa del espacio total de la Zona.");
                    } else {
                        zonaEntity.setEspacioParcial(zonaEntity.getEspacioParcial() + mercancia.getVolumen());
                        zonaRepository.save(zonaEntity);
                        return mapper.mercanciaCorrectaDTO(mercanciaRepository.save(mapper.mercanciaEntidadRequest(object)));
                    }
                } else throw new Exception("La zona buscada no existe.");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public MercanciaCorrectoDTO updateObject(Long idObject, MercanciaRequestDTO object) throws Exception {
        try {
            Optional<MercanciaEntity> search = mercanciaRepository.findById(idObject);
            MercanciaEntity mercancia = mapper.mercanciaEntidadRequest(object);
            if (search.isPresent()) {
                MercanciaEntity mercanciaEntity = search.get();
                if (mercancia.getNombre() == null || object.getNombre().length() == 0) {
                    throw new Exception("El nombre debe ser ingresado y no puede estar vacío.");
                } else if (mercancia.getDescripcion() == null || object.getDescripcion().length() == 0) {
                    throw new Exception("La descripción debe ser ingresada y no puede estar vacío.");
                } else if (mercancia.getFechaEntradaBodega() == null) {
                    throw new Exception("La fecha de entrada a bodega debe ser ingresada.");
                } else if (mercancia.getMotivoDevolucion() == null || object.getMotivoDevolucion().length() == 0) {
                    throw new Exception("El motivo de devolución debe ser ingresado y no puede estar vacío.");
                } else if (object.getIdZona() == null || object.getIdZona() == 0) {
                    throw new Exception("El id de la zona debe ser ingresado.");
                } else if (mercancia.getVolumen() == null || object.getVolumen() == 0) {
                    throw new Exception("El volumen debe ser ingresado y no puede ser 0.");
                } else {
                    Optional<ZonaEntity> zona = zonaRepository.findById(object.getIdZona());
                    if (zona.isPresent()) {
                        ZonaEntity zonaEntity = zona.get();
                        if (zonaEntity.getEspacioParcial() - mercanciaEntity.getVolumen() + mercancia.getVolumen() > zonaEntity.getEspacioTotal()) {
                            throw new Exception("El volumen se pasa del espacio total de la Zona.");
                        } else {
                            zonaEntity.setEspacioParcial(zonaEntity.getEspacioParcial() - mercanciaEntity.getVolumen() + mercancia.getVolumen());
                            zonaRepository.save(zonaEntity);
                        }
                    }
                }
                mercanciaEntity.setNombre(mercancia.getNombre());
                mercanciaEntity.setDescripcion(mercancia.getDescripcion());
                mercanciaEntity.setFechaEntradaBodega(mercancia.getFechaEntradaBodega());
                mercanciaEntity.setMotivoDevolucion(mercancia.getMotivoDevolucion());
                mercanciaEntity.setVolumen(mercancia.getVolumen());
                mercanciaEntity.setZona(mercancia.getZona());
                return mapper.mercanciaCorrectaDTO(mercanciaRepository.save(mercanciaEntity));
            }
            throw new Exception("No se encontró el id ingresado.");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean deleteObject(Long idObject) throws Exception {
        try {
            Optional<MercanciaEntity> mercancia = mercanciaRepository.findById(idObject);
            if (mercancia.isPresent()) {
                MercanciaEntity mercanciaEntity = mercancia.get();
                ZonaEntity zona = zonaRepository.findById(mercanciaEntity.getZona().getId()).get();
                zona.setEspacioParcial(zona.getEspacioParcial() - mercanciaEntity.getVolumen());
                zonaRepository.save(zona);
                mercanciaRepository.deleteById(idObject);
                return true;
            } else throw new Exception("No se encontro el objeto con ese id.");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
