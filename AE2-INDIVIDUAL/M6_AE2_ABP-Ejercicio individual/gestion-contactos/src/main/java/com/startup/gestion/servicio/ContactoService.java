package com.startup.gestion.servicio;

import com.startup.gestion.modelo.Contacto;
import java.util.List;

public interface ContactoService {
    void agregarContacto(Contacto contacto);
    List<Contacto> obtenerTodos();
    
    Contacto buscarPorNombre(String nombre);
}