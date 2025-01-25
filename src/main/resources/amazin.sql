CREATE TABLE Almacenes(
	almacen_id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(100) NOT NULL,                       
    capacidad_max INT NOT NULL,
    ocupacion INT DEFAULT 0,
    direccion VARCHAR(255),
	telefono VARCHAR(20)                               
);


CREATE TABLE Productos(
	producto_id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	nombre varchar(50) NOT NULL,
	descripcion varchar(250),
	categoria varchar(50),
	precio double NOT NULL,
	stock int,
	imagen blob
);

CREATE TABLE AlmacenesProductos (
    almacen_id BIGINT,
    producto_id BIGINT,
    cantidad INT NOT NULL,
    PRIMARY KEY (almacen_id, producto_id),
    FOREIGN KEY (almacen_id) REFERENCES Almacenes(almacen_id),
    FOREIGN KEY (producto_id) REFERENCES Productos(producto_id)
);

CREATE TABLE Destinos(
	destino_id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	nombre varchar(50) NOT NULL,
	distancia double NOT NULL,
	direccion VARCHAR(255)
);

CREATE TABLE Pedidos (
	pedido_id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	estado ENUM('ENVIADO', 'PLANIFICADO', 'FINALIZADO', 'CANCELADO') DEFAULT 'PLANIFICADO',
	fecha_de_pedido DATE,
	fecha_de_llegada DATE,
    almacen_id BIGINT,
    producto_id BIGINT,
    destino_id BIGINT,
    FOREIGN KEY (almacen_id) REFERENCES Almacenes(almacen_id), 
    FOREIGN KEY (producto_id) REFERENCES Productos(producto_id),
	FOREIGN KEY (destino_id) REFERENCES Destinos(destino_id)
);

CREATE TABLE Usuarios(
	usuario_id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL ,
	nom_usuario varchar(20) UNIQUE NOT NULL ,
	passw varchar(255) NOT NULL,	
	nombre varchar(100),
	email varchar(100)
);





