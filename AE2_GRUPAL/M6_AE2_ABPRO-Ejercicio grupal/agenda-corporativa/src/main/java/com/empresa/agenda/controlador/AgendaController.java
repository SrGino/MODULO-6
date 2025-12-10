package com.empresa.agenda.controlador;

import com.empresa.agenda.modelo.Evento;
import com.empresa.agenda.servicio.AgendaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @GetMapping("/")
    public String verAgenda(Model model) {
        model.addAttribute("eventos", agendaService.obtenerTodosOrdenados());
        return "lista-eventos";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("evento", new Evento());
        return "formulario-evento";
    }

    @PostMapping("/guardar")
    public String guardarEvento(@Valid @ModelAttribute("evento") Evento evento, 
                                BindingResult result, 
                                Model model) {
        
        if (result.hasErrors()) {
            return "formulario-evento";
        }

        agendaService.guardarEvento(evento);
        return "redirect:/";
    }
}