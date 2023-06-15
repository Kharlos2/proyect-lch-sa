package com.example.projectlchsa.mappers;

import com.example.projectlchsa.dtos.mercancia.MercanciaCorrectoDTO;
import com.example.projectlchsa.entities.MercanciaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MercanciaMapper {

    MercanciaCorrectoDTO mercanciaCorrectaDTO(MercanciaEntity mercanciaEntity);
    List<MercanciaCorrectoDTO> mercanciasCorrectasDTOs(List<MercanciaEntity> mercanciaEntities);

    @InheritInverseConfiguration
    MercanciaEntity mercanciaEntidad(MercanciaCorrectoDTO mercanciaCorrectoDTO);
    List<MercanciaEntity> mercanciasEntidades(List<MercanciaCorrectoDTO> mercanciaCorrectoDTOS);
}
