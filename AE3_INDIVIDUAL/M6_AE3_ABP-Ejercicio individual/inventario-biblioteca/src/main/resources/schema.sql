CREATE TABLE IF NOT EXISTS libros_jdbc (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    anio_publicacion INT
);