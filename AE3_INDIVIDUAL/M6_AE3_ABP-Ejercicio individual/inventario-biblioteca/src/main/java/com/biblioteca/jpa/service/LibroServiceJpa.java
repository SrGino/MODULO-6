package com.biblioteca.jpa.service;

import com.biblioteca.jpa.entity.AutorEntity;
import com.biblioteca.jpa.entity.LibroEntity;
import com.biblioteca.jpa.repository.AutorRepository;
import com.biblioteca.jpa.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LibroServiceJpa {

    @Autowired
    private AutorRepository autorRepository;
    
    @Autowired
    private LibroRepository libroRepository;
    
    @Transactional
    public void registrarAutorYLibro(String nombreAutor, String tituloLibro) {
        
        // Crear y guardar Autor
        AutorEntity autor = new AutorEntity(nombreAutor);
        // save() devuelve la entidad con el ID generado
        autor = autorRepository.save(autor); 
        
        System.out.println("Autor guardado con ID: " + autor.getId());

        // Simulación de validación de negocio
        if (tituloLibro == null || tituloLibro.trim().isEmpty()) {
            throw new IllegalArgumentException("El libro debe tener título (Provocando Rollback)");
        }

        // Creacion de libro.
        LibroEntity libro = new LibroEntity(tituloLibro);
        libro.setAutor(autor);
        
        // Guardar libro
        libroRepository.save(libro);
        System.out.println("Libro guardado exitosamente.");
    }

    public List<LibroEntity> obtenerTodosLosLibros() {
        return libroRepository.findAll();
    }
}