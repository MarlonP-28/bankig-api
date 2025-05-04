-- Tabla base: Persona
CREATE TABLE persona (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    genero VARCHAR(255) NOT NULL,
    edad INT NOT NULL CHECK (edad >= 18),
    identificacion VARCHAR(13) NOT NULL UNIQUE,
    direccion VARCHAR(255) NOT NULL,
    telefono VARCHAR(255) NOT NULL,
    DTYPE VARCHAR(31)  -- Utilizado por Hibernate para distinguir subclases
);

-- Tabla Cliente: hereda de Persona y usa la misma clave primaria
CREATE TABLE cliente (
    id BIGINT PRIMARY KEY,  -- MISMA clave primaria que persona.id
    contrasena VARCHAR(255) NOT NULL,
    estado BOOLEAN NOT NULL,
    FOREIGN KEY (id) REFERENCES persona(id)
);

-- Tabla Cuenta con relación a Cliente
CREATE TABLE cuenta (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    numero_cuenta VARCHAR(255) NOT NULL UNIQUE,
    tipo_cuenta VARCHAR(255) NOT NULL,
    saldo_inicial DECIMAL(10,2) NOT NULL,
    estado BOOLEAN NOT NULL,
    cliente_id BIGINT NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);
