package com.biblioteca.jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "libros_jpa") // Nombre diferente para no chocar con JDBC
public class LibroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String titulo;

    // Relación Muchos a Uno: Muchos libros pertenecen a un autor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private AutorEntity autor;

    public LibroEntity() {}
    public LibroEntity(String titulo) { this.titulo = titulo; }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public AutorEntity getAutor() { return autor; }
    public void setAutor(AutorEntity autor) { this.autor = autor; }
}