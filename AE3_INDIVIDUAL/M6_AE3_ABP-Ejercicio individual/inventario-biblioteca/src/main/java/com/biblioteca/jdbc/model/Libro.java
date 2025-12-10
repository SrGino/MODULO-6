package com.biblioteca.jdbc.model;

public class Libro {
    private Long id;
    private String titulo;
    private Integer anioPublicacion;

    public Libro() {}

    public Libro(Long id, String titulo, Integer anioPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public Integer getAnioPublicacion() { return anioPublicacion; }
    public void setAnioPublicacion(Integer anioPublicacion) { this.anioPublicacion = anioPublicacion; }
}