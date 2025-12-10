package com.empresa.agenda.servicio;

import com.empresa.agenda.modelo.Evento;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgendaServiceImpl implements AgendaService {

    private List<Evento> listaEventos = new ArrayList<>();

    public AgendaServiceImpl() {
        listaEventos.add(new Evento("Cumpleaños Jefe", LocalDate.now().plusDays(5), "Pastel y bebidas", "RRHH"));
        listaEventos.add(new Evento("Reunión Anual", LocalDate.now().plusDays(20), "Auditorio Principal", "Gerencia"));
        listaEventos.add(new Evento("Viernes Casual", LocalDate.now().plusDays(2), "Pizza en la oficina", "Comité de Bienestar"));
    }

    @Override
    public void guardarEvento(Evento evento) {
        listaEventos.add(evento);
        System.out.println("Evento guardado: " + evento.getTitulo());
    }

    @Override
    public List<Evento> obtenerTodosOrdenados() {
        return listaEventos.stream()
                .sorted(Comparator.comparing(Evento::getFecha))
                .collect(Collectors.toList());
    }
}