CREATE TABLE  IF NOT EXISTS almacenes(
    almacen_id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(100) UNIQUE NOT NULL,
    capacidad_max INT NOT NULL,
    ocupacion INT DEFAULT 0,
    direccion VARCHAR(255),
    telefono VARCHAR(20),
    producto_id BIGINT
);

CREATE TABLE IF NOT EXISTS productos(
    producto_id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nombre varchar(50) UNIQUE NOT NULL,
    descripcion varchar(250),
    categoria varchar(50),
    precio double NOT NULL,
    stock int,
    imagen blob,
    almacen_id BIGINT,
    FOREIGN KEY (almacen_id) REFERENCES almacenes(almacen_id)
);

CREATE TABLE IF NOT EXISTS destinos(
    destino_id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nombre varchar(50) UNIQUE NOT NULL,
    tipo ENUM('TIENDA','ESCUELA','HOSPITAL','VIVIENDA','GIMNASIO','OFICINA'),
    distancia double NOT NULL,
    direccion VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS pedidos(
    pedido_id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    estado ENUM('ENVIADO', 'PLANIFICADO', 'FINALIZADO', 'CANCELADO') DEFAULT 'PLANIFICADO',
    fecha_de_pedido DATE,
    fecha_de_llegada DATE,
    producto_id BIGINT,
    destino_id BIGINT,
    FOREIGN KEY (producto_id) REFERENCES productos(producto_id) ON DELETE CASCADE,
    FOREIGN KEY (destino_id) REFERENCES destinos(destino_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS usuarios(
    usuario_id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL ,
    nom_usuario varchar(20) UNIQUE NOT NULL ,
    passw varchar(255) NOT NULL,
    nombre varchar(100),
    email varchar(100)
);