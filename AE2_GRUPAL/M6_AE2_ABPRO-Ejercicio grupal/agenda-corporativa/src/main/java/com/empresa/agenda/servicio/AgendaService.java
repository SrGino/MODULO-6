package com.empresa.agenda.servicio;

import com.empresa.agenda.modelo.Evento;
import java.util.List;

public interface AgendaService {
    void guardarEvento(Evento evento);
    List<Evento> obtenerTodosOrdenados();
}