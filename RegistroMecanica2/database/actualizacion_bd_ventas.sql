
USE Mecanica;

-- ==========================================
-- 1. RENOMBRAR TABLA VENTA ORIGINAL
-- ==========================================

RENAME TABLE venta TO venta_anterior;


-- ==========================================
-- 2. CREAR NUEVA TABLA VENTA (CABECERA)
-- ==========================================

CREATE TABLE venta (
    codigo INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    nombre_cliente VARCHAR(150) NOT NULL,
    monto_total DECIMAL(10,2) NOT NULL DEFAULT 0.00
) ENGINE=InnoDB;


-- ==========================================
-- 3. CREAR TABLA DETALLE_VENTA
-- ==========================================

CREATE TABLE detalle_venta (
    codigo INT AUTO_INCREMENT PRIMARY KEY,
    codigo_venta INT NOT NULL,
    codigo_producto INT NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10,2) NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,

    CONSTRAINT fk_detalle_venta
        FOREIGN KEY (codigo_venta)
        REFERENCES venta(codigo),

    CONSTRAINT fk_detalle_producto
        FOREIGN KEY (codigo_producto)
        REFERENCES inventario(codigo)
) ENGINE=InnoDB;


-- ==========================================
-- 4. MIGRAR LAS VENTAS ANTERIORES
-- ==========================================

INSERT INTO venta
(codigo, fecha, nombre_cliente, monto_total)
SELECT
    codigo,
    fecha,
    CONCAT_WS(' ', nombre_comprador,
              apellido_paterno, apellido_materno),
    pago
FROM venta_anterior;


-- ==========================================
-- 5. MIGRAR LOS DETALLES ANTERIORES
-- ==========================================

INSERT INTO detalle_venta
(codigo_venta, codigo_producto, cantidad,
 precio_unitario, subtotal)
SELECT
    codigo,
    codigo_producto,
    cantidad,
    ROUND(pago / cantidad, 2),
    pago
FROM venta_anterior
WHERE cantidad > 0;

