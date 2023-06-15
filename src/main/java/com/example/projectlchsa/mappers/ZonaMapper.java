package com.example.projectlchsa.mappers;

import com.example.projectlchsa.dtos.zona.ZonaCorrectoDTO;
import com.example.projectlchsa.entities.ZonaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ZonaMapper {

    ZonaCorrectoDTO zonaCorrectaDTO(ZonaEntity zonaEntity);
    List<ZonaCorrectoDTO> zonasCorrectasDTOs(List<ZonaEntity> zonaEntities);

    @InheritInverseConfiguration
    ZonaEntity zonaEntidad(ZonaCorrectoDTO zonaCorrectoDTO);
    List<ZonaEntity> zonasEntidades(List<ZonaCorrectoDTO> zonaCorrectoDTOS);
}
