INSERT INTO persona (dtype, id, nombre, genero, edad, identificacion, direccion, telefono) VALUES
('Persona', 1, 'Jose Lema', 'Masculino', 29, '1726890985', 'Otavalo', '098254785'),
('Persona', 2, 'Marianela Montalvo', 'Femenino', 35, '1725489658', 'Quito', '096315478');

INSERT INTO cliente (cliente_id, contraseña, estado, id) VALUES
(1, '1234', TRUE, 1),
(2, '5678', TRUE, 2);

INSERT INTO cuenta (id, numero_cuenta, tipo_cuenta, saldo_inicial, estado, cliente_id) VALUES
(1, '478758', 'Ahorro', 2000.00, TRUE, 1),
(2, '225487', 'Corriente', 100.00, TRUE, 2),
(3, '495878', 'Ahorros', 0.00, TRUE, 2),
(4, '496825', 'Ahorros', 540.00, TRUE, 2);