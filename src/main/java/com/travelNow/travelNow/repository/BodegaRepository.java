package com.travelNow.travelNow.repository;

import com.travelNow.travelNow.model.Bodega;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BodegaRepository extends JpaRepository<Bodega, Long> {
    List<Bodega> findByNombreContainingIgnoreCase(String nombre);
    List<Bodega> findByUbicacionContainingIgnoreCase(String ubicacion);
}