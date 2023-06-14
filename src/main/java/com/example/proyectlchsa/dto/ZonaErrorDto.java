package com.example.proyectlchsa.dto;

public class ZonaErrorDto extends ZonaDto{

    private String mensaje;

    public ZonaErrorDto(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
