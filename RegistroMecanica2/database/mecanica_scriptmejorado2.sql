-- =====================================================
-- Base de datos: Mecanica
-- Sistema de Gestión Automotriz
-- =====================================================

CREATE DATABASE IF NOT EXISTS Mecanica
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_general_ci;

USE Mecanica;

-- -----------------------------------------------------
-- Tabla: servicio
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS servicio (
    codigo           INT AUTO_INCREMENT PRIMARY KEY,
    fecha            DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    nombre           VARCHAR(50)  NOT NULL,
    apellido_paterno VARCHAR(50)  NOT NULL,
    apellido_materno VARCHAR(50),
    telefono         VARCHAR(15),
    pago             DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    descripcion      TEXT
);

-- -----------------------------------------------------
-- Tabla: inventario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS inventario (
    codigo  INT AUTO_INCREMENT PRIMARY KEY,
    nombre  VARCHAR(100) NOT NULL,
    unidad  INT NOT NULL DEFAULT 0   -- cantidad de productos en stock
);

-- -----------------------------------------------------
-- Tabla: venta
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS venta (
    codigo            INT AUTO_INCREMENT PRIMARY KEY,
    fecha             DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    codigo_producto   INT NOT NULL,
    nombre_producto   VARCHAR(100) NOT NULL,
    nombre_comprador  VARCHAR(50)  NOT NULL,
    apellido_paterno  VARCHAR(50)  NOT NULL,
    apellido_materno  VARCHAR(50),
    telefono          VARCHAR(15),
    pago              DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    cantidad          INT NOT NULL,
    CONSTRAINT fk_venta_producto
        FOREIGN KEY (codigo_producto) REFERENCES inventario(codigo)
);

-- -----------------------------------------------------
-- Tabla: compra
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS compra (
    codigo            INT AUTO_INCREMENT PRIMARY KEY,
    fecha             DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    codigo_producto   INT NOT NULL,
    nombre_producto   VARCHAR(100) NOT NULL,
    nombre_proveedor  VARCHAR(100) NOT NULL,
    telefono          VARCHAR(15),
    pago              DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    cantidad          INT NOT NULL,
    CONSTRAINT fk_compra_producto
        FOREIGN KEY (codigo_producto) REFERENCES inventario(codigo)
);

-- =====================================================
-- DATOS DE EJEMPLO
-- =====================================================

-- Inventario (primero, porque venta y compra dependen de esta tabla)
INSERT INTO inventario (nombre, unidad) VALUES
('Aceite de motor 10W-40', 25),
('Filtro de aceite', 40),
('Filtro de aire', 30),
('Pastillas de freno', 20),
('Bujía NGK', 60),
('Batería 12V', 8),
('Líquido de frenos', 15),
('Refrigerante 1L', 18);

-- Servicios
INSERT INTO servicio (fecha, nombre, apellido_paterno, apellido_materno, telefono, pago, descripcion) VALUES
('2026-11-02 09:15:00', 'Carlos',  'Ramírez',  'Torres',  '987654321', 120.00, 'Cambio de aceite y filtro de aceite'),
('2026-11-02 11:40:00', 'Lucía',   'Quispe',   'Huamán',  '912345678', 250.00, 'Cambio de pastillas de freno delanteras'),
('2026-11-03 10:00:00', 'Miguel',  'Flores',   NULL,      '965432178', 80.00,  'Revisión general y alineamiento'),
('2026-11-04 15:30:00', 'Rosa',    'Mendoza',  'Castro',  '934567812', 180.00, 'Cambio de batería y revisión del sistema eléctrico'),
('2026-11-05 08:45:00', 'Jorge',   'Salazar',  'Rojas',   '976543210', 300.00, 'Afinamiento completo: bujías, filtro de aire y aceite');

-- Compras (a proveedores)
INSERT INTO compra (fecha, codigo_producto, nombre_producto, nombre_proveedor, telefono, pago, cantidad) VALUES
('2026-10-28 10:00:00', 1, 'Aceite de motor 10W-40', 'Lubricantes del Perú SAC', '014567890', 600.00, 20),
('2026-10-28 10:20:00', 2, 'Filtro de aceite',       'Repuestos Lima EIRL',      '014561234', 320.00, 40),
('2026-10-30 14:00:00', 4, 'Pastillas de freno',     'Frenos y Más SAC',         '014569876', 900.00, 20),
('2026-11-01 09:30:00', 5, 'Bujía NGK',              'Repuestos Lima EIRL',      '014561234', 480.00, 60),
('2026-11-03 16:00:00', 6, 'Batería 12V',            'Baterías Andinas SAC',     '014563210', 1200.00, 8);

-- Ventas (a compradores)
INSERT INTO venta (fecha, codigo_producto, nombre_producto, nombre_comprador, apellido_paterno, apellido_materno, telefono, pago, cantidad) VALUES
('2026-11-02 12:10:00', 1, 'Aceite de motor 10W-40', 'Pedro', 'Gutiérrez', 'Soto',   '987123456', 70.00,  2),
('2026-11-03 09:50:00', 3, 'Filtro de aire',         'Ana',   'Paredes',   NULL,     '912987654', 45.00,  1),
('2026-11-04 13:25:00', 5, 'Bujía NGK',              'Luis',  'Cárdenas',  'Lara',   '965123987', 60.00,  4),
('2026-11-05 10:05:00', 7, 'Líquido de frenos',      'María', 'Vega',      'Núñez',  '934876512', 35.00,  1),
('2026-11-05 17:20:00', 8, 'Refrigerante 1L',        'Juan',  'Medina',    NULL,     '976321654', 50.00,  2);