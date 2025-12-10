package com.biblioteca.jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autores")
public class AutorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nombre;

    // Relación Uno a Muchos: Un autor tiene muchos libros
    // cascade = CascadeType.ALL permite guardar libros automáticamente al guardar el autor
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LibroEntity> libros = new ArrayList<>();

    // Constructores
    public AutorEntity() {}
    public AutorEntity(String nombre) { this.nombre = nombre; }

    // Helper para mantener la consistencia bidireccional
    public void agregarLibro(LibroEntity libro) {
        libros.add(libro);
        libro.setAutor(this);
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public List<LibroEntity> getLibros() { return libros; }
    public void setLibros(List<LibroEntity> libros) { this.libros = libros; }
}