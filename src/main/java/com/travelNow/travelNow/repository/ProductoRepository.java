package com.travelNow.travelNow.repository;

import com.travelNow.travelNow.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
    List<Producto> findByPrecioGreaterThanEqual(BigDecimal precio);
    List<Producto> findByPrecioLessThanEqual(BigDecimal precio);
    List<Producto> findByPrecioBetween(BigDecimal precio1, BigDecimal precio2);
}