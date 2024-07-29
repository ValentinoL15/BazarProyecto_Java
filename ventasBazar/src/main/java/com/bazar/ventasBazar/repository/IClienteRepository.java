package com.bazar.ventasBazar.repository;

import com.bazar.ventasBazar.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IClienteRepository extends JpaRepository<Cliente,Long>{
    
}
