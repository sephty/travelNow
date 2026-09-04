package com.travelNow.travelNow.mapper;

import com.travelNow.travelNow.dto.response.ProductoResponse;
import com.travelNow.travelNow.dto.request.ProductoRequest;
import com.travelNow.travelNow.model.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    public ProductoResponse entityToDto(Producto producto) {
        if (producto == null) return null;
        return new ProductoResponse(
                producto.getId(),
                producto.getNombre(),
                producto.getStock(),
                producto.getBodega_id(),
                producto.getPrecio(),
                producto.getFechaCreacion()
        );
    }

    public Producto dtoToEntity(ProductoRequest dto) {
        if (dto == null) return null;
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setStock(dto.getStock());
        producto.getBodega_id();
        producto.setPrecio(dto.getPrecio());
        return producto;
    }

    public void updateEntityToDto(Producto producto, ProductoRequest dto) {
        if (dto == null || producto == null) return;
        producto.setNombre(dto.getNombre());
        producto.setStock(dto.getStock());
        producto.getBodega_id();
        producto.setPrecio(dto.getPrecio());
    }
}