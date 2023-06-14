package com.example.proyectlchsa.mappers;


import com.example.proyectlchsa.dto.ZonaCorrectaDto;
import com.example.proyectlchsa.dto.ZonaErrorDto;
import com.example.proyectlchsa.entities.Zona;
import org.mapstruct.InheritInverseConfiguration;

import java.util.List;

public interface ZonaMapper {

    ZonaCorrectaDto zonaCorrectaDto (Zona zona);

    List<ZonaCorrectaDto> zonasDto (List<Zona> zonas);
    @InheritInverseConfiguration
    Zona zona (ZonaCorrectaDto zonaCorrectaDto);
}
