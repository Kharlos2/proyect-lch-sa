package com.example.proyectlchsa.controllers;

import com.example.proyectlchsa.repositories.MercanciaRepository;
import com.example.proyectlchsa.services.MercanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mercancia")
public class MercanciaController {

    @Autowired
    private MercanciaService mercanciaService;

}
