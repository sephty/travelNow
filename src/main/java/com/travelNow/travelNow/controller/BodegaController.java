package com.travelNow.travelNow.controller;


import com.travelNow.travelNow.dto.request.BodegaRequest;
import com.travelNow.travelNow.dto.response.BodegaResponse;
import com.travelNow.travelNow.service.BodegaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bodegas")
@RequiredArgsConstructor
public class BodegaController {

    private final BodegaService bodegaService;

    @PostMapping
    public ResponseEntity<BodegaResponse> guardar(
            @Valid @RequestBody BodegaRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bodegaService.guardar(dto));
    }

    @GetMapping
    public ResponseEntity<List<BodegaResponse>> obtenerTodas() {
        return ResponseEntity.ok(bodegaService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BodegaResponse> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(bodegaService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BodegaResponse> actualizar(@PathVariable Long id,
            @Valid @RequestBody BodegaRequest dto){
        return ResponseEntity.ok(bodegaService.actualizarBodega(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        bodegaService.eliminarBodega(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<BodegaResponse>> buscarPorNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(bodegaService.buscarPorNombre(nombre));
    }

    @GetMapping("/ubicacion")
    public ResponseEntity<List<BodegaResponse>> buscarPorUbicacion(@RequestParam String ubicacion) {
        return ResponseEntity.ok(bodegaService.buscarPorUbicacion(ubicacion));
    }
}
