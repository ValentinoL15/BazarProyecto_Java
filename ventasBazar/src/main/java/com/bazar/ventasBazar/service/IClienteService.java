package com.bazar.ventasBazar.service;

import com.bazar.ventasBazar.model.Cliente;
import java.util.List;

public interface IClienteService {
    
    public List<Cliente> getClientes();
    
    public Cliente getCliente(Long id_cliente);
    
    public void saveCliente(Cliente cliente);
    
    public void deleteCliente(Long id_cliente);
    
    public void editCliente(Cliente cliente);
    
}
