CREATE DATABASE Farmacia;
USE Farmacia;
CREATE TABLE medicamento(
codigo INT PRIMARY KEY,
laboratorio VARCHAR(45),
componentes VARCHAR(45),
precio INT,
nombre VARCHAR(45),
excipiente VARCHAR(45)
);

CREATE TABLE empleado(
ci_id INT(4) PRIMARY KEY,
nombre VARCHAR(45),
direccion VARCHAR(100),
telefono INT(8)
);

CREATE TABLE cliente(
ci_id INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(45),
apellido VARCHAR(45)
);

CREATE TABLE venta(
numero_id INT AUTO_INCREMENT,
fecha DATE,
medicamento_id INT, 
cliente_id INT,
empleado_id INT(4),
PRIMARY KEY(numero_id,medicamento_id,cliente_id,empleado_id)
);

CREATE TABLE tipo(
funcion VARCHAR(45) PRIMARY KEY,
detalle VARCHAR(200)
);

CREATE TABLE factura(
venta_id INT,
cliente_ci_id INT,
medicamento_ci_id INT,
cantidad INT,
precio_total INT,
PRIMARY KEY(venta_id,cliente_ci_id,medicamento_ci_id)
);

CREATE TABLE tipo_medicamento(
codigo_id INT,
funcion_f VARCHAR(45),
PRIMARY KEY(codigo_id, funcion_f)
);


ALTER TABLE venta ADD FOREIGN KEY (medicamento_id) REFERENCES medicamento (codigo);
ALTER TABLE venta ADD FOREIGN KEY (cliente_id) REFERENCES cliente (ci_id);
ALTER TABLE venta ADD FOREIGN KEY (empleado_id) REFERENCES empleado (ci_id);

ALTER TABLE factura ADD FOREIGN KEY (venta_id,cliente_ci_id,medicamento_ci_id) REFERENCES venta (numero_id,cliente_id,medicamento_id);

ALTER TABLE tipo_medicamento ADD FOREIGN KEY (codigo_id) REFERENCES medicamento (codigo);
ALTER TABLE tipo_medicamento ADD FOREIGN KEY (funcion_f) REFERENCES tipo (funcion);

