package com.biblioteca.jdbc.service;

import com.biblioteca.jdbc.dao.LibroDAO;
import com.biblioteca.jdbc.model.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LibroServiceJdbc {

    @Autowired
    private LibroDAO libroDAO;

    public void registrarLibro(Libro libro) {
        if (libro.getTitulo() == null || libro.getTitulo().isEmpty()) {
            throw new IllegalArgumentException("El título no puede estar vacío");
        }
        libroDAO.insertar(libro);
    }

    public List<Libro> listarLibros() {
        return libroDAO.obtenerTodos();
    }
}