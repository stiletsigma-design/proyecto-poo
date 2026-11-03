-- ============================================
-- Sistema de Gestión Automotriz
-- Base de datos: Mecanica (MySQL)
-- ============================================

DROP DATABASE IF EXISTS Mecanica;
CREATE DATABASE Mecanica;
USE Mecanica;

-- ---------- TABLAS ----------

CREATE TABLE Servicio (
    codigo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido_paterno VARCHAR(50) NOT NULL,
    apellido_materno VARCHAR(50),
    telefono VARCHAR(15),
    pago DECIMAL(10,2) NOT NULL,
    descripcion VARCHAR(255),
    fecha DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Producto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    categoria VARCHAR(50),
    precio_compra DECIMAL(10,2) NOT NULL,
    precio_venta DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL DEFAULT 0
);

CREATE TABLE Proveedor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(15)
);

CREATE TABLE Venta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    cliente VARCHAR(100),
    total DECIMAL(10,2) NOT NULL
);

CREATE TABLE DetalleVenta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_venta INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_venta) REFERENCES Venta(id),
    FOREIGN KEY (id_producto) REFERENCES Producto(id)
);

CREATE TABLE Compra (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    id_proveedor INT NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_proveedor) REFERENCES Proveedor(id)
);

CREATE TABLE DetalleCompra (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_compra INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_compra) REFERENCES Compra(id),
    FOREIGN KEY (id_producto) REFERENCES Producto(id)
);

-- ---------- DATOS DE PRUEBA ----------

INSERT INTO Servicio (nombre, apellido_paterno, apellido_materno, telefono, pago, descripcion, fecha)
VALUES
('Carlos', 'Ramírez',  'Torres', '987654321', 150.00, 'Cambio de aceite y filtro',  '2026-10-05 09:15:00'),
('Lucía',  'Gómez',    'Vega',   '912345678', 300.00, 'Cambio de pastillas de freno', '2026-10-12 11:40:00'),
('Miguel', 'Soto',     NULL,     '955443322',  80.00, 'Alineamiento y balanceo',     '2026-10-20 15:30:00');

INSERT INTO Producto (nombre, categoria, precio_compra, precio_venta, stock)
VALUES
('Aceite de motor 10W-40 (1 galón)', 'Lubricantes',  45.00,  65.00, 25),
('Filtro de aceite',                 'Filtros',       12.00,  22.00, 40),
('Filtro de aire',                   'Filtros',       18.00,  30.00, 30),
('Pastillas de freno delanteras',    'Frenos',        60.00,  95.00, 15),
('Bujía',                            'Motor',          8.00,  15.00, 60),
('Batería 12V',                      'Eléctrico',    250.00, 350.00,  8);

INSERT INTO Proveedor (nombre, telefono)
VALUES ('Repuestos Lima SAC', '014567890');