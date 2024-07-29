package com.bazar.ventasBazar.controller;

import com.bazar.ventasBazar.dto.MontoDTO;
import com.bazar.ventasBazar.model.Producto;
import com.bazar.ventasBazar.model.Venta;
import com.bazar.ventasBazar.service.IVentaService;
import java.time.LocalDate;
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
public class VentaController {
    
    @Autowired
    private IVentaService ventaServ;
    
    @GetMapping("/ventas/traer")
    public List<Venta> getVentas(){
        List<Venta> listaVentas = ventaServ.getVentas();
        return listaVentas;
    }
    
    @GetMapping("/venta/traer/{codigo_venta}")
    public Venta getVenta(@PathVariable Long codigo_venta) {
        return ventaServ.getVenta(codigo_venta);
    }
    
    @PostMapping("/venta/crear")
    public String crearVenta(@RequestBody Venta venta){ 
        
        ventaServ.saveVenta(venta);

        
        return "La venta se ha creado con exito";
    }
    
    @DeleteMapping("/venta/eliminar/{codigo_venta}")
    public String deleteVenta(@PathVariable Long codigo_venta){ 
       ventaServ.deleteVenta(codigo_venta);
       
       return "La venta se ha eliminado con exito";
    }
    
    @PutMapping("venta/editar")
    public Venta editVenta(@RequestBody Venta venta){
        ventaServ.editVenta(venta);
        
        return ventaServ.getVenta(venta.getCodigo_venta());
    }
    
    @GetMapping("/ventas/productos/{codigo_venta}")                             //////////////////////////////////////////////////////////////////////////////////
    public List<Producto> getListaDisponible(@PathVariable Long codigo_venta){
        
        return ventaServ.listaDeProductos(codigo_venta);
    }
    
    @GetMapping("/traer/fecha/{fechaVenta}")
    public List<Venta> getDia(@PathVariable LocalDate fechaVenta){
        return ventaServ.getDia(fechaVenta);
    }
    
    
    @GetMapping("/ventas/{fechaVenta}")                                         //////////////////////////////////////////////////////////////////////////////////
    public String ventaDias(@PathVariable LocalDate fechaVenta){
       return ventaServ.ventaDias(fechaVenta);
    }
    
    @GetMapping("/getCosto/{codigo_venta}")
    public Venta traerCosto(@PathVariable Long codigo_venta){
        return ventaServ.getTotal(codigo_venta);
    }
    
    @GetMapping("/ventas/mayor_venta")                                          ///////////////////////////////////////////PATRON DTO/////////////////////////////
    public MontoDTO getMonto(MontoDTO monto){
        return ventaServ.getMonto(monto);
    }
   
    
    
    
}
