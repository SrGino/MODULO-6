package com.startup.gestion.modelo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Component
@Scope("prototype")
public class Contacto {

    @NotEmpty(message = "El nombre es obligatorio")
    @Size(min = 3, message = "El nombre debe tener al menos 3 letras")
    private String nombre;

    @NotEmpty(message = "El correo es obligatorio")
    @Email(message = "Debe ser un correo válido")
    private String correo;

    @NotEmpty(message = "El teléfono es obligatorio")
    private String telefono;

    // Constructor vacío necesario para Spring y Beans
    public Contacto() {}

    public Contacto(String nombre, String correo, String telefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    
    @Override
    public String toString() {
        return "Contacto [nombre=" + nombre + ", correo=" + correo + "]";
    }
}