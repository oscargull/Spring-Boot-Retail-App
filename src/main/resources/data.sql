INSERT IGNORE INTO usuarios(nom_usuario,passw,email) VALUES
    ('admin','$2a$12$dLuG3q.fJty6l1gTYLZ2fe2FgsvdmXOQrN7iXfw/q5FwlIy5XRkyi','admin@quandaledingle.com')
    ON DUPLICATE KEY UPDATE
            passw = VALUES(passw),
            email = VALUES(email);

INSERT IGNORE INTO almacenes (nombre, capacidad_max, ocupacion, direccion, telefono) VALUES
        ('Almacén Central', 5000, 2500, 'Calle Principal 123, Ciudad A', '912345678'),
        ('Almacén Norte', 3000, 1200, 'Avenida del Parque 45, Ciudad B', '913456789'),
        ('Almacén Sur', 4000, 3000, 'Calle del Sol 67, Ciudad C', '914567890'),
        ('Almacén Este', 2000, 800, 'Plaza Mayor 89, Ciudad D', '915678901'),
        ('Almacén Oeste', 3500, 2000, 'Calle del Río 12, Ciudad E', '916789012')
        ON DUPLICATE KEY UPDATE
            capacidad_max = VALUES(capacidad_max),
            ocupacion = VALUES(ocupacion),
            direccion = VALUES(direccion),
            telefono = VALUES(telefono);

INSERT IGNORE INTO destinos (nombre, tipo, distancia, direccion) VALUES
        ('Madrid', 'TIENDA', 14, 'Puerta del Sol, Madrid, España'),
        ('Barcelona', 'VIVIENDA', 72, 'La Rambla, Barcelona, España'),
        ('Sevilla', 'VIVIENDA', 54, 'Plaza de España, Sevilla, España'),
        ('Valencia', 'ESCUELA', 35, 'Plaza del Ayuntamiento, Valencia, España'),
        ('Granada', 'TIENDA', 23, 'Alhambra, Granada, España'),
        ('Bilbao', 'HOSPITAL', 65, 'Museo Guggenheim, Bilbao, España'),
        ('Málaga', 'VIVIENDA', 83, 'Calle Larios, Málaga, España')
        ON DUPLICATE KEY UPDATE
            tipo = VALUES(tipo),
            distancia = VALUES(distancia),
            direccion = VALUES(direccion);

INSERT IGNORE INTO productos(nombre, descripcion, categoria, precio, stock) VALUES
        ('Auriculares Bluetooth', 'Auriculares inalámbricos con sonido de alta calidad y batería de larga duración.', 'Electrónica', 59.99, 80),
        ('Mochila Deportiva', 'Mochila resistente al agua, ideal para deportes y actividades al aire libre.', 'Ropa', 35.50, 60),
        ('Lámpara LED', 'Lámpara moderna con luz regulable, perfecta para estudios y oficinas.', 'Iluminación', 22.90, 120),
        ('Reloj Inteligente', 'Reloj con pantalla táctil, monitor de actividad y notificaciones al alcance de tu muñeca.', 'Electrónica', 99.99, 70),
        ('Cartera de Cuero', 'Cartera elegante de cuero genuino con varios compartimentos.', 'Accesorios', 45.00, 150),
        ('Guitarra Eléctrica', 'Guitarra eléctrica para principiantes con todo lo necesario para comenzar a tocar.', 'Instrumentos', 199.00, 25),
        ('Chaqueta de Invierno', 'Chaqueta acolchonada, ideal para las bajas temperaturas invernales.', 'Ropa', 75.99, 90),
        ('Silla Eléctrica', 'Silla ergonómica para gamers, con múltiples ajustes y gran comodidad.', 'Muebles', 150.00, 40),
        ('Patinete Eléctrico', 'Patinete eléctrico plegable, con batería de larga duración y velocidad máxima de 25 km/h.', 'Electrónica', 349.99, 15),
        ('Cámara de Seguridad', 'Cámara IP de alta definición con visión nocturna, ideal para proteger tu hogar.', 'Electrónica', 69.99, 50),
        ('Sofá de 3 Plazas', 'Sofá de diseño moderno y cómodo, perfecto para el salón de tu hogar.', 'Muebles', 350.00, 15),
        ('Termo de Acero Inoxidable', 'Termo para bebidas calientes o frías, con capacidad de 1 litro y diseño compacto.', 'Accesorios', 25.99, 80),
        ('Bicicleta de Montaña', 'Bicicleta resistente, ideal para rutas de montaña y terrenos difíciles.', 'Deportes', 220.00, 30),
        ('Hidratante Facial', 'Crema hidratante de alta calidad, ideal para pieles sensibles.', 'Cosméticos', 18.50, 200),
        ('Cámara Instantánea', 'Cámara fotográfica que imprime tus fotos al instante, perfecta para eventos y recuerdos.', 'Electrónica', 85.00, 50),
        ('Manta de Lana', 'Manta suave y cálida, ideal para las noches frías de invierno.', 'Ropa', 40.00, 120),
        ('Taza de Cerámica', 'Taza de cerámica con diseño exclusivo, perfecta para tus bebidas calientes.', 'Accesorios', 10.00, 250),
        ('Pantalones Vaqueros', 'Jeans de corte clásico, cómodos y de excelente ajuste.', 'Ropa', 29.99, 100),
        ('Lentes de Sol', 'Lentes de sol con protección UV, de diseño moderno y elegante.', 'Accesorios', 40.00, 150),
        ('Freidora de Aire', 'Freidora sin aceite para cocinar de manera más saludable, con múltiples funciones.', 'Electrodomésticos', 120.00, 40)
        ON DUPLICATE KEY UPDATE
            descripcion = VALUES(descripcion),
            categoria = VALUES(categoria),
            precio = VALUES(precio),
            stock = VALUES(stock);



