package com.travelNow.travelNow.service;

import com.travelNow.travelNow.dto.request.BodegaRequest;
import com.travelNow.travelNow.dto.response.BodegaResponse;
import com.travelNow.travelNow.mapper.BodegaMapper;
import com.travelNow.travelNow.model.Bodega;
import com.travelNow.travelNow.repository.BodegaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BodegaService {

    private final BodegaRepository bodegaRepository;
    private final BodegaMapper bodegaMapper;

    public BodegaResponse guardar(BodegaRequest dto) {
        Bodega bodega = bodegaMapper.dtoToEntity(dto);
        return bodegaMapper.entityToDto(bodegaRepository.save(bodega));
    }

    public List<BodegaResponse> obtenerTodas() {
        return bodegaRepository.findAll().stream()
                .map(bodegaMapper::entityToDto)
                .toList();
    }

    public BodegaResponse obtenerPorId(Long id) {
        return bodegaMapper.entityToDto(buscarEntidadPorId(id));
    }

    @Transactional
    public BodegaResponse actualizarBodega(Long id, BodegaRequest dto) {
        Bodega bodega = buscarEntidadPorId(id);
        bodegaMapper.updateEntityToDto(bodega, dto);
        return bodegaMapper.entityToDto(bodegaRepository.save(bodega));
    }

    @Transactional
    public void eliminarBodega(Long id) {
        bodegaRepository.delete(buscarEntidadPorId(id));
    }

    public List<BodegaResponse> buscarPorNombre(String nombre) {
        return bodegaRepository.findByNombreContainingIgnoreCase(nombre).stream()
                .map(bodegaMapper::entityToDto)
                .toList();
    }

    public List<BodegaResponse> buscarPorUbicacion(String ubicacion) {
        return bodegaRepository.findByUbicacionContainingIgnoreCase(ubicacion).stream()
                .map(bodegaMapper::entityToDto)
                .toList();
    }

    private Bodega buscarEntidadPorId(Long id) {
        return bodegaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Bodega no encontrada con id: " + id));
    }
}
