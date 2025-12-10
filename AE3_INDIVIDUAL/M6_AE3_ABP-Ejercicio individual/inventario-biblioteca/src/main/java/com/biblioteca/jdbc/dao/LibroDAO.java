package com.biblioteca.jdbc.dao;

import com.biblioteca.jdbc.model.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LibroDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // RowMapper para convertir filas de la BD a objetos Java
    private final RowMapper<Libro> libroRowMapper = new RowMapper<Libro>() {
        @Override
        public Libro mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Libro(
                rs.getLong("id"),
                rs.getString("titulo"),
                rs.getInt("anio_publicacion")
            );
        }
    };

    // Insertar
    public int insertar(Libro libro) {
        String sql = "INSERT INTO libros_jdbc (titulo, anio_publicacion) VALUES (?, ?)";
        return jdbcTemplate.update(sql, libro.getTitulo(), libro.getAnioPublicacion());
    }

    // Consultar todos
    public List<Libro> obtenerTodos() {
        String sql = "SELECT * FROM libros_jdbc";
        return jdbcTemplate.query(sql, libroRowMapper);
    }

    // Consultar por año
    public List<Libro> obtenerPorAnio(int anio) {
        String sql = "SELECT * FROM libros_jdbc WHERE anio_publicacion = ?";
        return jdbcTemplate.query(sql, libroRowMapper, anio);
    }

    // Actualizar título
    public int actualizarTitulo(Long id, String nuevoTitulo) {
        String sql = "UPDATE libros_jdbc SET titulo = ? WHERE id = ?";
        return jdbcTemplate.update(sql, nuevoTitulo, id);
    }

    // Eliminar
    public int eliminar(Long id) {
        String sql = "DELETE FROM libros_jdbc WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}