package com.travelNow.travelNow.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BodegaResponse {
    private Long id;
    private String nombre;
    private String ubicacion;
    private Boolean activo;
    private LocalDateTime fechaCreacion;
}
