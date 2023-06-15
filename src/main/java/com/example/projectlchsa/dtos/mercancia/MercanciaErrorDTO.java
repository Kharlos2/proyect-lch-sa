package com.example.projectlchsa.dtos.mercancia;

public class MercanciaErrorDTO extends MercanciaDTO {

    private String mensaje;

    public MercanciaErrorDTO(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
