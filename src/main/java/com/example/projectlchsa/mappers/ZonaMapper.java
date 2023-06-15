package com.example.projectlchsa.mappers;

import com.example.projectlchsa.dtos.zona.ZonaCorrectoDTO;
import com.example.projectlchsa.dtos.zona.ZonaRequestDTO;
import com.example.projectlchsa.entities.ZonaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ZonaMapper {

    ZonaCorrectoDTO zonaCorrectaDTO(ZonaEntity zonaEntity);
    List<ZonaCorrectoDTO> zonasCorrectasDTOs(List<ZonaEntity> zonaEntities);

    @InheritInverseConfiguration
    ZonaEntity zonaEntidad(ZonaCorrectoDTO zonaCorrectoDTO);
    List<ZonaEntity> zonasEntidades(List<ZonaCorrectoDTO> zonaCorrectoDTOS);

    @Mappings({
            @Mapping(source = "espacioTotal", target = "total"),
            @Mapping(source = "espacioParcial", target = "parcial")
    })
    ZonaRequestDTO zonaPeticionDTO(ZonaEntity zonaEntity);
    List<ZonaRequestDTO> zonasPeticionesDTOs(List<ZonaEntity> zonaEntities);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "mercanciaEntities", ignore = true)
    })
    ZonaEntity zonaEntidadRequest(ZonaRequestDTO zonaRequestDTO);
    List<ZonaEntity> zonasEntidadesRequest(List<ZonaRequestDTO> zonaRequestDTOS);
}
