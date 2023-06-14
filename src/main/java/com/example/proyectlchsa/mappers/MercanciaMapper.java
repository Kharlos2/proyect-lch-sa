package com.example.proyectlchsa.mappers;

import com.example.proyectlchsa.dto.MercanciaCorrectaDto;
import com.example.proyectlchsa.entities.Mercancia;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MercanciaMapper {

    MercanciaCorrectaDto mercaciaCorrectaDto(Mercancia mercancia);

    List<MercanciaCorrectaDto> mercanciasCorrectasDto(List<Mercancia> mercancias);

    @InheritInverseConfiguration
    Mercancia mercancia (MercanciaCorrectaDto mercanciaCorrectaDto);
}
