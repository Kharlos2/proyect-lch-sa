package com.example.proyectlchsa.mappers;

import com.example.proyectlchsa.dto.mercancia.MercanciaCorrectaDto;
import com.example.proyectlchsa.entities.MercanciaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MercanciaMapper {

    MercanciaCorrectaDto mercaciaCorrectaDto(MercanciaEntity mercanciaEntity);

    List<MercanciaCorrectaDto> mercanciasCorrectasDto(List<MercanciaEntity> mercanciaEntities);

    @InheritInverseConfiguration
    MercanciaEntity mercancia(MercanciaCorrectaDto mercanciaCorrectaDto);
    List<MercanciaEntity> mercancias(List<MercanciaCorrectaDto> mercanciaCorrectaDtos);
}
