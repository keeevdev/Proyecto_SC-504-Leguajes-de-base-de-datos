package com.lenguajes.controller;

import com.lenguajes.domain.Pedido;
import com.lenguajes.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/buscar-pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public String buscarPedido(@RequestParam("idPedido") Long idPedido, Model model) {
        Optional<Pedido> pedidoOpt = pedidoService.findById(idPedido);
        if (pedidoOpt.isPresent()) {
            Pedido pedido = pedidoOpt.get();
            model.addAttribute("pedido", pedido);
            return "consultarPedido";  // Nombre de la plantilla Thymeleaf que creamos arriba
        } else {
            model.addAttribute("error", "Pedido no encontrado");
            return "redirect:/buscar-pedido";
        }
    }
}
