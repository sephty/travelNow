DROP DATABASE IF EXISTS TravelNow;
CREATE DATABASE TravelNow CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE TravelNow;


CREATE TABLE bodegas (
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre         VARCHAR(100) NOT NULL,
    ubicacion      VARCHAR(150) NOT NULL,
    activo         BOOLEAN NOT NULL DEFAULT TRUE,
    fecha_creacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB;

CREATE TABLE productos (
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre         VARCHAR(150) NOT NULL,
    precio         DECIMAL(12,2) NOT NULL DEFAULT 0.00,
    bodega_id	   BIGINT NOT NULL,
    fecha_creacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_inventario_bodega   FOREIGN KEY (bodega_id) REFERENCES bodegas(id)
) ENGINE=InnoDB;