package com.startup.gestion.controlador;

import com.startup.gestion.modelo.Contacto;
import com.startup.gestion.servicio.ContactoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactoController {

    @Autowired
    private ContactoService contactoService;

    @GetMapping("/contactos")
    public String listarContactos(Model model) {
        model.addAttribute("lista", contactoService.obtenerTodos());
        return "lista-contactos";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("contacto", new Contacto());
        return "formulario-contacto";
    }

    @PostMapping("/guardar")
    public String guardarContacto(@Valid @ModelAttribute("contacto") Contacto contacto, 
                                  BindingResult result, 
                                  Model model) {
        
        // Validación de campos
        if (result.hasErrors()) {
            return "formulario-contacto";
        }

        contactoService.agregarContacto(contacto);
        return "redirect:/contactos";
    }
}