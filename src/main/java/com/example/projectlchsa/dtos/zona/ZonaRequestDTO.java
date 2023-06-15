package com.example.projectlchsa.dtos.zona;

public class ZonaRequestDTO extends ZonaDTO {

    private Double total;
    private Double parcial;

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getParcial() {
        return parcial;
    }

    public void setParcial(Double parcial) {
        this.parcial = parcial;
    }

    @Override
    public String toString() {
        return "ZonaRequestDTO{" +
                "total=" + total +
                ", parcial=" + parcial +
                '}';
    }
}
