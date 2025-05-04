-- Personas que son clientes (DTYPE indica la subclase)
INSERT INTO persona (id, nombre, genero, edad, identificacion, direccion, telefono, DTYPE)
VALUES 
(1, 'Juan Perez', 'Masculino', 30, '1234567890', 'Calle 1', '0991234567', 'Cliente'),
(2, 'Maria Gomez', 'Femenino', 28, '0987654321', 'Calle 2', '0987654321', 'Cliente');

-- Cliente hereda de persona usando misma ID
INSERT INTO cliente (id, contrasena, estado) VALUES 
(1, 'clave123', TRUE),
(2, 'clave456', TRUE);

-- Cuentas asociadas a los clientes
INSERT INTO cuenta (numero_cuenta, tipo_cuenta, saldo_inicial, estado, cliente_id)
VALUES 
('478758', 'Ahorro', 2000.00, TRUE, 1),
('225487', 'Corriente', 100.00, TRUE, 2),
('495878', 'Ahorros', 0.00, TRUE, 2),
('496825', 'Ahorros', 540.00, TRUE, 2);
