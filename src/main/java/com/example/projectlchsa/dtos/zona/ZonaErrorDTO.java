package com.example.projectlchsa.dtos.zona;

public class ZonaErrorDTO extends ZonaDTO {

    private String mensaje;

    public ZonaErrorDTO(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
