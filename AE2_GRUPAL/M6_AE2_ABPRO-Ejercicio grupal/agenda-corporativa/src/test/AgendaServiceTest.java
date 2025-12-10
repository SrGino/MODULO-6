package com.empresa.agenda;

import com.empresa.agenda.modelo.Evento;
import com.empresa.agenda.servicio.AgendaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class AgendaServiceTest {

    @Autowired
    private AgendaService agendaService;

    @Test
    void testGuardarYListar() {
        Evento nuevo = new Evento("Test JUnit", LocalDate.now().plusDays(10), "Test Desc", "Tester");
        
        agendaService.guardarEvento(nuevo);
        
        List<Evento> eventos = agendaService.obtenerTodosOrdenados();

        Assertions.assertFalse(eventos.isEmpty(), "La lista no debería estar vacía");
        
        boolean encontrado = eventos.stream()
                .anyMatch(e -> e.getTitulo().equals("Test JUnit"));
        
        Assertions.assertTrue(encontrado, "El evento guardado debe existir");
    }
}