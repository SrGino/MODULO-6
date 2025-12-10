package com.equipo.controlador;

import com.equipo.modelo.Usuario;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormularioController {
    @GetMapping("/")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "formulario";
    }

    @PostMapping("/procesar")
    public String procesarFormulario(@Valid Usuario usuario, BindingResult result, Model model) {
        
        if (result.hasErrors()) {
            return "formulario";
        }

        return "resultado";
    }
}