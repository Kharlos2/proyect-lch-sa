package com.example.proyectlchsa.mappers;


import com.example.proyectlchsa.dto.zona.ZonaCorrectaDto;
import com.example.proyectlchsa.entities.ZonaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ZonaMapper {

    ZonaCorrectaDto zonaCorrectaDto(ZonaEntity zonaEntity);

    List<ZonaCorrectaDto> zonasDto(List<ZonaEntity> zonaEntities);
    @InheritInverseConfiguration
    ZonaEntity zona(ZonaCorrectaDto zonaCorrectaDto);
    List<ZonaEntity> zonas(List<ZonaCorrectaDto> zonaCorrectaDtos);
}
