package com.example.projectlchsa.controllers;

import com.example.projectlchsa.dtos.mercancia.MercanciaDTO;
import com.example.projectlchsa.dtos.mercancia.MercanciaErrorDTO;
import com.example.projectlchsa.dtos.mercancia.MercanciaRequestDTO;
import com.example.projectlchsa.entities.MercanciaEntity;
import com.example.projectlchsa.services.MercanciaService;
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
@RequestMapping("/mercancias")
@Tag(name = "Servicio mercancia", description = "Servicios que ofrecen CRUD en la entidad mercancia")
public class MercanciaController {

    @Autowired
    private MercanciaService service;

    @Operation(summary = "Busca todas las mercancias")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Todas las mercancias encontradas",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MercanciaEntity.class)) }),
            @ApiResponse(responseCode = "404", description = "No se encuentran mercancias",
                    content = @Content)
    })
    @GetMapping("/")
    public ResponseEntity<List<MercanciaDTO>> findAll() {
        try {
            return ResponseEntity.ok(new ArrayList<>(service.findAll()));
        }catch (Exception e){
            List<MercanciaDTO> mercanciaDtos = new ArrayList<>();
            mercanciaDtos.add(new MercanciaErrorDTO(e.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mercanciaDtos);
        }
    }

    @Operation(summary = "Busca una mercancia por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mercancia encontrada",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MercanciaEntity.class)) }),
            @ApiResponse(responseCode = "404", description = "No se encontro mercancia",
                    content = @Content)
    })
    @GetMapping("/{idObject}")
    public ResponseEntity<MercanciaDTO> findObject(@PathVariable Long idObject) {
        try {
            return ResponseEntity.ok(service.findObject(idObject));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MercanciaErrorDTO(e.getMessage()));
        }
    }

    @Operation(summary = "Guarda mercancia en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Mercancia guardada",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MercanciaEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Mercancia no valida",
                    content = @Content)
    })
    @PostMapping("/")
    public ResponseEntity<MercanciaDTO> saveObject(@RequestBody MercanciaRequestDTO mercanciaRequestDTO) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.saveObject(mercanciaRequestDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MercanciaErrorDTO(e.getMessage()));
        }
    }

    @Operation(summary = "Actualiza mercancia por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Mercancia actualizada correctamente",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MercanciaEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Mercancia no valida",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Mercancia no encontrada",
                    content = @Content)
    })
    @PutMapping("/{idObject}")
    public ResponseEntity<MercanciaDTO> updateObject(@PathVariable Long idObject, @RequestBody MercanciaRequestDTO mercanciaRequestDTO) {
        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.updateObject(idObject, mercanciaRequestDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MercanciaErrorDTO(e.getMessage()));
        }
    }

    @Operation(summary = "Borra mercancia usando id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mercancia Borrada",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MercanciaEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Mercancia no encontrada",
                    content = @Content)
    })
    @DeleteMapping("/{idObject}")
    public ResponseEntity<MercanciaDTO> deleteObject(@PathVariable Long idObject) {
        try {
            service.deleteObject(idObject);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MercanciaErrorDTO(e.getMessage()));
        }
    }
}
