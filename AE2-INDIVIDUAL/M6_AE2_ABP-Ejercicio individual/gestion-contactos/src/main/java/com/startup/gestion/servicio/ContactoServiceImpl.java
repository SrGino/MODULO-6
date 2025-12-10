package com.startup.gestion.servicio;

import com.startup.gestion.modelo.Contacto;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContactoServiceImpl implements ContactoService {

    // Lista en memoria para simular base de datos
    private List<Contacto> listaContactos = new ArrayList<>();

    public ContactoServiceImpl() {
        // Datos iniciales de prueba
        listaContactos.add(new Contacto("Ana Lopez", "ana@startup.com", "+56912345678"));
        listaContactos.add(new Contacto("Carlos Diaz", "carlos@startup.com", "+56987654321"));
    }

    @Override
    public void agregarContacto(Contacto contacto) {
        listaContactos.add(contacto);
        System.out.println("LOG: Contacto registrado -> " + contacto.getNombre());
    }

    @Override
    public List<Contacto> obtenerTodos() {
        return listaContactos;
    }

    @Override
    public Contacto buscarPorNombre(String nombre) {
        return listaContactos.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }
}