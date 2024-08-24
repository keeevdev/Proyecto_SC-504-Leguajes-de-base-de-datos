package com.lenguajes.controller;

import com.lenguajes.domain.Entrega;
import com.lenguajes.impl.EntregaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/check-entrega")
public class EntregaController {

    @Autowired
    private EntregaServiceImpl entregaService;

    @PostMapping
    public String checkEntrega(@ModelAttribute("entrega") Entrega entrega, Model model) {
        Optional<Entrega> entregaOpt = entregaService.findById(entrega.getIdEntrega());
        if (entregaOpt.isPresent()) {
            Entrega entregaEncontrada = entregaOpt.get();
            model.addAttribute("entrega", entregaEncontrada);
            return "estadoEntrega"; 
        } else {
            model.addAttribute("error", "Entrega no encontrada");
            return "redirect:/entrega";
        }
    }
}


