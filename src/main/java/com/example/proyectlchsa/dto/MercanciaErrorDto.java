package com.example.proyectlchsa.dto;

public class MercanciaErrorDto extends MercanciaDto{

    private String mensaje;

    public MercanciaErrorDto(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
