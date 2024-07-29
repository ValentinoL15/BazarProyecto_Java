package com.bazar.ventasBazar.repository;

import com.bazar.ventasBazar.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository <Producto,Long>{
    
    
    
}
