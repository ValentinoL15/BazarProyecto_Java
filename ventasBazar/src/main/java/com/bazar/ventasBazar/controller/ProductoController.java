package com.bazar.ventasBazar.controller;

import com.bazar.ventasBazar.model.Producto;
import com.bazar.ventasBazar.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
    
    @Autowired
    private IProductoService productoServ;
    
    @GetMapping("/productos/traer")
    public List<Producto> getProductos() {
        return productoServ.getProductos();
    }
    
    @GetMapping("/producto/traer/{codigo_producto}")
    public Producto getProducto(@PathVariable Long codigo_producto){
        return productoServ.getProducto(codigo_producto);
    }
    
    @PostMapping("/producto/crear")                                             /////////////////////////////////////////
    public String crearProducto(@RequestBody Producto producto){
        productoServ.saveProducto(producto);
        
        return "El producto ha sido creado correctamente";
    }
    
    @DeleteMapping("/producto/eliminar/{codigo_producto}")                      
    public String deleteProducto(@PathVariable Long codigo_producto){
        productoServ.deleteProducto(codigo_producto);
        
        return "EL producto se ha eliminado con exito";
    }
    
    @PutMapping("/producto/editar")
    public Producto editProducto(@RequestBody Producto producto){
        productoServ.editProducto(producto);
        
        return productoServ.getProducto(producto.getCodigo_producto());
    }
    
    @GetMapping("/productos/falta_stock")
    public List<Producto> listaDisponible(){
       return productoServ.getCantidadDispo();
    }
}
