package com.travelNow.travelNow.controller;


import com.travelNow.travelNow.dto.request.ProductoRequest;
import com.travelNow.travelNow.dto.response.ProductoResponse;
import com.travelNow.travelNow.service.ProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @PostMapping
    public ResponseEntity<ProductoResponse> guardar(
            @Valid @RequestBody ProductoRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.guardar(dto, userDetails.getId()));
    }

    @GetMapping
    public ResponseEntity<List<ProductoResponse>> obtenerTodas() {
        return ResponseEntity.ok(productoService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponse> obtenerPorId(
         @PathVariable Long id) {
        return ResponseEntity.ok(productoService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponse> actualizar(@PathVariable Long id,
            @Valid @RequestBody ProductoRequest dto) {
        return ResponseEntity.ok(productoService.actualizarProducto(id, dto, userDetails.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id,) {
        productoService.eliminarProducto(id, userDetails.getId());
        return ResponseEntity.noContent().build();
    }

}