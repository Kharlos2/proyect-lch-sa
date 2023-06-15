package com.example.projectlchsa.mappers;

import com.example.projectlchsa.dtos.mercancia.MercanciaCorrectoDTO;
import com.example.projectlchsa.dtos.mercancia.MercanciaRequestDTO;
import com.example.projectlchsa.entities.MercanciaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MercanciaMapper {

    MercanciaCorrectoDTO mercanciaCorrectaDTO(MercanciaEntity mercanciaEntity);
    List<MercanciaCorrectoDTO> mercanciasCorrectasDTOs(List<MercanciaEntity> mercanciaEntities);

    @InheritInverseConfiguration
    MercanciaEntity mercanciaEntidad(MercanciaCorrectoDTO mercanciaCorrectoDTO);
    List<MercanciaEntity> mercanciasEntidades(List<MercanciaCorrectoDTO> mercanciaCorrectoDTOS);

    @Mapping(source = "zona.id", target = "idZona")
    MercanciaRequestDTO mercanciaPeticionDTO(MercanciaEntity mercanciaEntity);
    List<MercanciaRequestDTO> mercanciasPeticionesDTOs(List<MercanciaEntity> mercanciaEntities);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "iup", ignore = true)
    })
    MercanciaEntity mercanciaEntidadRequest(MercanciaRequestDTO mercanciaRequestDTO);
    List<MercanciaEntity> mercanciasEntidadesRequest(List<MercanciaRequestDTO> mercanciaRequestDTOS);
}
