package com.example.projectlchsa.controllers;

import com.example.projectlchsa.dtos.zona.ZonaDTO;
import com.example.projectlchsa.dtos.zona.ZonaErrorDTO;
import com.example.projectlchsa.dtos.zona.ZonaRequestDTO;
import com.example.projectlchsa.entities.ZonaEntity;
import com.example.projectlchsa.services.ZonaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/zonas")
@Tag(name = "Servicio zona", description = "Servicios que ofrecen CRUD en la entidad zona")
public class ZonaController {

    @Autowired
    private ZonaService service;

    @Operation(summary = "Busca todas las zonas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Todas las zonas encontradas",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ZonaEntity.class)) }),
            @ApiResponse(responseCode = "404", description = "No se encuentran zonas",
                    content = @Content)
    })
    @GetMapping("/")
    public ResponseEntity<List<ZonaDTO>> findAll() {
        try {
            return ResponseEntity.ok(new ArrayList<>(service.findAll()));
        }catch (Exception e){
            List<ZonaDTO> mercanciaDtos = new ArrayList<>();
            mercanciaDtos.add(new ZonaErrorDTO(e.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mercanciaDtos);
        }
    }

    @Operation(summary = "Busca una zona por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Zona encontrada",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ZonaEntity.class)) }),
            @ApiResponse(responseCode = "404", description = "No se encontro zona",
                    content = @Content)
    })
    @GetMapping("/{idObject}")
    public ResponseEntity<ZonaDTO> findObject(@PathVariable Long idObject) {
        try {
            return ResponseEntity.ok(service.findObject(idObject));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ZonaErrorDTO(e.getMessage()));
        }
    }

    @Operation(summary = "Guarda zona en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Zona guardada",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ZonaEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Zona no valida",
                    content = @Content)
    })
    @PostMapping("/")
    public ResponseEntity<ZonaDTO> saveObject(@RequestBody ZonaRequestDTO zonaRequestDTO) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.saveObject(zonaRequestDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ZonaErrorDTO(e.getMessage()));
        }
    }

    @Operation(summary = "Actualiza zona por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Zona actualizada correctamente",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ZonaEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Zona no valida",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Zona no encontrada",
                    content = @Content)
    })
    @PutMapping("/{idObject}")
    public ResponseEntity<ZonaDTO> updateObject(@PathVariable Long idObject, @RequestBody ZonaRequestDTO zonaRequestDTO) {
        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.updateObject(idObject, zonaRequestDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ZonaErrorDTO(e.getMessage()));
        }
    }

    @Operation(summary = "Borra zona usando id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Zona Borrada",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ZonaEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Zona no encontrada",
                    content = @Content)
    })
    @DeleteMapping("/{idObject}")
    public ResponseEntity<ZonaDTO> deleteObject(@PathVariable Long idObject) {
        try {
            service.deleteObject(idObject);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ZonaErrorDTO(e.getMessage()));
        }
    }
}
