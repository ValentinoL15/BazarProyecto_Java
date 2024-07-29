package com.bazar.ventasBazar.service;

import com.bazar.ventasBazar.model.Producto;
import com.bazar.ventasBazar.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService{
    
    @Autowired
    private IProductoRepository productoRepo;

    @Override
    public List<Producto> getProductos() {
        List<Producto> listaProductos = productoRepo.findAll();
        return listaProductos;
    }

    @Override
    public Producto getProducto(Long codigo_producto) {
        return productoRepo.findById(codigo_producto).orElse(null);
    }

    @Override
    public void saveProducto(Producto producto) {
        productoRepo.save(producto);
    }

    @Override
    public void deleteProducto(Long codigo_producto) {
       productoRepo.deleteById(codigo_producto);
    }

    @Override
    public void editProducto(Producto producto) {
        this.saveProducto(producto);
    }

    @Override
    public List<Producto> getCantidadDispo() {
        List<Producto> listaProductos = this.getProductos();
        List<Producto> listaDisponibles = new ArrayList<Producto>();
        
        for(Producto produc : listaProductos) {
            if(produc.getCantidad_disponible() < 5){ 
                listaDisponibles.add(produc);
            } 
        }
        return listaDisponibles;
    }
    
}
