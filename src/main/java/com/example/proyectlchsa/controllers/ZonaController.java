package com.example.proyectlchsa.controllers;

import com.example.proyectlchsa.dto.*;
import com.example.proyectlchsa.entities.Zona;
import com.example.proyectlchsa.services.ZonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("zonas")
public class ZonaController {

    @Autowired
    private ZonaService zonaService;

    public ResponseEntity<List<ZonaDto>> findAll() throws Exception{
        try {
            return ResponseEntity.ok(new ArrayList<>(zonaService.findAll()));
        }catch (Exception e){
            List<ZonaDto> mercanciaDtos = new ArrayList<>();
            mercanciaDtos.add(new ZonaErrorDto(e.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mercanciaDtos);
        }
    }

    public ResponseEntity<ZonaDto> saveObject(Zona zona){
        return null;
    }
}
