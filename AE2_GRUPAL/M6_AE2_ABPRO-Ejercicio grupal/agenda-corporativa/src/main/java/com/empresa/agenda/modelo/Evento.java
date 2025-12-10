package com.empresa.agenda.modelo;

import java.time.LocalDate;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


@Component
@Scope("prototype")
public class Evento {

    @NotEmpty(message = "El título es obligatorio")
    private String titulo;

    @NotNull(message = "La fecha es obligatoria")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "La fecha no puede ser en el pasado")
    private LocalDate fecha;

    @NotEmpty(message = "La descripción es obligatoria")
    private String descripcion;

    @NotEmpty(message = "El responsable es obligatorio")
    private String responsable;

    public Evento() {}

    public Evento(String titulo, LocalDate fecha, String descripcion, String responsable) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.responsable = responsable;
    }

    // Getters y Setters
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getResponsable() { return responsable; }
    public void setResponsable(String responsable) { this.responsable = responsable; }
}