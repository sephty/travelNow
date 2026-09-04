package com.travelNow.travelNow.service;

import com.travelNow.travelNow.dto.response.ProductoResponse;
import com.travelNow.travelNow.dto.request.ProductoRequest
import java.util.List;

ProductoService {
    ProductoResponse guardar(ProductoRequest dto);
    List<ProductoResponse> obtenerTodas();
    ProductoResponse actualizarProducto(Long id, ProductoRequest dto);
    void eliminarProducto(Long id);
    List<ProductoResponse> buscarPorNombre(String nombre);
