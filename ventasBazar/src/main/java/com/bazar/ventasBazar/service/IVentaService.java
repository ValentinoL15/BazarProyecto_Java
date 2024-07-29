package com.bazar.ventasBazar.service;

import com.bazar.ventasBazar.dto.MontoDTO;
import com.bazar.ventasBazar.model.Producto;
import com.bazar.ventasBazar.model.Venta;
import java.time.LocalDate;
import java.util.List;

public interface IVentaService {

    public List<Venta> getVentas();
    
    public Venta getVenta(Long codigo_venta);
    
    public List<Venta> getDia(LocalDate fechaVenta);
    
    public void saveVenta(Venta venta);
    
    public void deleteVenta(Long codigo_venta);
    
    public void editVenta(Venta venta);
    
    public List<Producto> listaDeProductos(Long codigo_venta);
    
    public String ventaDias(LocalDate fechaVenta);
    
    public Venta getTotal(Long codigo_venta);
    
    public MontoDTO getMonto(MontoDTO monto);
    
  
    
}
