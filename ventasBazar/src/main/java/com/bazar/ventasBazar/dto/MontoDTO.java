package com.bazar.ventasBazar.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MontoDTO {
    
    private Long codigo_venta;
    private Double total;
    private int cantidadProductos;
    private String nombre;
    private String apellido;

    public MontoDTO() {
    }

    public MontoDTO(Long codigo_venta, Double total, int cantidadProductos, String nombre, String apellido) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.cantidadProductos = cantidadProductos;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
}
