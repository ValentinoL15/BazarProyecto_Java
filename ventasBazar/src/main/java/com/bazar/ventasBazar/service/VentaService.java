package com.bazar.ventasBazar.service;

import com.bazar.ventasBazar.dto.MontoDTO;
import com.bazar.ventasBazar.model.Producto;
import com.bazar.ventasBazar.model.Venta;
import com.bazar.ventasBazar.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaRepository ventaRepo;
 
    
    @Override
    public List<Venta> getVentas() {
        List<Venta> listaVentas = ventaRepo.findAll();
        double total = 0.0;
        for(Venta lista : listaVentas){
            List<Producto> producto = lista.getListaProductos();
            for(Producto produc : producto){
                total = total + produc.getCosto();
               double cantidad = produc.getCantidad_disponible() - 1.0;
               produc.setCantidad_disponible(cantidad);
            }
            lista.setTotal(total);
            total = 0.0;
        }
        return listaVentas;
    }

    @Override
    public Venta getVenta(Long codigo_venta) {
        
        return ventaRepo.findById(codigo_venta).orElse(null);
    }
    
    

    @Override
    public void saveVenta(Venta venta) {
        ventaRepo.save(venta);
        
    }

    @Override
    public void deleteVenta(Long codigo_venta) {
        ventaRepo.deleteById(codigo_venta);
    }

    @Override
    public void editVenta(Venta venta) {
        this.saveVenta(venta);
    }

    @Override
    public List<Producto> listaDeProductos(Long codigo_venta) {
        
     Venta venta = this.getVenta(codigo_venta);
     
     return venta.getListaProductos();
     
    }
    
    @Override
    public List<Venta> getDia(LocalDate fechaVenta) {
        return ventaRepo.findByFechaVenta(fechaVenta);
    }
  

    @Override
    public String ventaDias(LocalDate fechaVenta) {
        List<Venta> listaVenta = this.getDia(fechaVenta);
        double total = 0.0;
        int dias = 0;
        
        for(Venta venta : listaVenta){
            if(venta.getTotal() != 0){
                total = total + venta.getTotal();
                dias = dias + 1;
            }
        }
        return "EL total es: " + total + ", y la cantidad de ventas durante el dia de la fecha es de: " + dias + " ventas";
    }

    @Override
    public Venta getTotal(Long codigo_venta) {
        Venta venta = this.getVenta(codigo_venta);
        
        venta.calcularTotal();
        
        return ventaRepo.findById(codigo_venta).orElse(null);
    }

    @Override
    public MontoDTO getMonto(MontoDTO monto) {
        List<Venta> listaVentas = ventaRepo.findAll();
        MontoDTO mon = new MontoDTO();
       double productoMasCaro = 0.0;
        for(Venta lista : listaVentas){
                 int totalProductos = 0; 
                for(Producto producto : lista.getListaProductos()){
                    if(producto.getCosto() > productoMasCaro){
                        productoMasCaro = producto.getCosto();
                        mon.setTotal(productoMasCaro);  
                        mon.setNombre(lista.getUnCliente().getNombre());
                        mon.setApellido(lista.getUnCliente().getApellido());
                        mon.setCodigo_venta(lista.getCodigo_venta());
                        List<Producto> listaProducto = lista.getListaProductos();
                        totalProductos = listaProducto.size();
                        mon.setCantidadProductos(totalProductos);
                        System.out.println(totalProductos);
                    }  
                }
        }
        return mon;
    }

   

    
}

    


  


  

   
   
  
    

