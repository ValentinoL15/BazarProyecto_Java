package com.bazar.ventasBazar.model;

import com.bazar.ventasBazar.repository.IVentaRepository;
import com.bazar.ventasBazar.service.IVentaService;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter @Setter
@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long codigo_venta;
    private LocalDate fecha_venta;
    private Double total;
    
    @ManyToMany
    private List<Producto> listaProductos;
    
    @OneToOne
    @JoinColumn(name = "id_cliente_venta", referencedColumnName = "id_cliente")
    private Cliente unCliente;

    public Venta() {
    }

    public Venta(Long codigo_venta, LocalDate fecha_venta, Double total, List<Producto> listaProductos, Cliente unCliente) {
        this.codigo_venta = codigo_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.listaProductos = listaProductos;
        this.unCliente = unCliente;
    }
    
    
      
    public void calcularTotal() {
        double totales = 0.0;
        for(Producto prod : listaProductos){
            totales = totales + prod.getCosto();
        }
        this.total = totales;
    }

    
    
}
