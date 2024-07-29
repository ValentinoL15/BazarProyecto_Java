package com.bazar.ventasBazar.repository;

import com.bazar.ventasBazar.model.Venta;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta,Long>{
    @Query("SELECT v FROM Venta v WHERE v.fecha_venta = :fechaVenta")
    List<Venta> findByFechaVenta(LocalDate fechaVenta);
    

    
}
