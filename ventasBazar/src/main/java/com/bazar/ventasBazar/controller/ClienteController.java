package com.bazar.ventasBazar.controller;

import com.bazar.ventasBazar.model.Cliente;
import com.bazar.ventasBazar.repository.IClienteRepository;
import com.bazar.ventasBazar.service.IClienteService;
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
public class ClienteController {
 
    @Autowired
    private IClienteService clienteServ;
    
    @GetMapping("/clientes/traer")
    public List<Cliente> getClientes(){
        List<Cliente> listaClientes = clienteServ.getClientes();
        return listaClientes;
    }
    
    @GetMapping("/cliente/traer/{id_cliente}")
    public Cliente getCliente(@PathVariable Long id_cliente){
        return clienteServ.getCliente(id_cliente);
    }
    
    @PostMapping("/cliente/crear")
    public String crearCliente(@RequestBody Cliente cliente){
        clienteServ.saveCliente(cliente);
        
        return "El cliente fue creado con exito";
    }
    
    @DeleteMapping("/cliente/eliminar/{id_cliente}")
    public String deleteCliente(@PathVariable Long id_cliente){
        clienteServ.deleteCliente(id_cliente);
        
        return "El cliente se elimino con exito";
    }
    
    @PutMapping("/cliente/editar")
    public Cliente editCliente(@RequestBody Cliente cliente){
        clienteServ.editCliente(cliente);
        
        return clienteServ.getCliente(cliente.getId_cliente());
    }
}
