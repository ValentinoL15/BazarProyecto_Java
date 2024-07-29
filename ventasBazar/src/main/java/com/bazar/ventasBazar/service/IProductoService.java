package com.bazar.ventasBazar.service;

import com.bazar.ventasBazar.model.Producto;
import java.util.List;

public interface IProductoService {
    
    public List<Producto> getProductos();
    
    public Producto getProducto(Long codigo_producto);
    
    public void saveProducto(Producto producto);
    
    public void deleteProducto(Long codigo_producto);
    
    public void editProducto(Producto producto);
    
    public List<Producto> getCantidadDispo();
    
}
