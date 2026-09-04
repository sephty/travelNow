package com.travelNow.travelNow.mapper;


import com.travelNow.travelNow.dto.response.BodegaResponse;
import com.travelNow.travelNow.dto.request.BodegaRequest;
import com.travelNow.travelNow.model.Bodega;
import org.springframework.stereotype.Component;

@Component
public class BodegaMapper {

    public BodegaResponse entityToDto(Bodega bodega) {
        if (bodega == null) return null;
        return new BodegaResponse(
                bodega.getId(),
                bodega.getNombre(),
                bodega.getUbicacion(),
                bodega.getActivo(),
                bodega.getFechaCreacion()
        );
    }

    public Bodega dtoToEntity(BodegaRequest dto) {
        if (dto == null) return null;
        Bodega bodega = new Bodega();
        bodega.setNombre(dto.getNombre());
        bodega.setUbicacion(dto.getUbicacion());
        bodega.setActivo(true);
        return bodega;
    }

    public void updateEntityToDto(Bodega bodega, BodegaRequest dto) {
        if (dto == null || bodega == null) return;
        bodega.setNombre(dto.getNombre());
        bodega.setUbicacion(dto.getUbicacion());
    }
}