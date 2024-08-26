package com.lenguajes.controller;

import com.lenguajes.domain.Pedido;
import com.lenguajes.service.PedidoService;
import com.lenguajes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String listPedidos(Model model) {
        model.addAttribute("pedidos", pedidoService.findAll());
        return "pedido/list";
    }

    @GetMapping("/create")
    public String createPedidoForm(Model model) {
        model.addAttribute("pedido", new Pedido());
        model.addAttribute("clientes", clienteService.findAll());
        return "pedido/form";
    }

    @PostMapping("/save")
    public String savePedido(@ModelAttribute Pedido pedido) {
        pedidoService.save(pedido);
        return "redirect:/pedidos";
    }

    @GetMapping("/edit/{id}")
    public String editPedidoForm(@PathVariable("id") Long id, Model model) {
        Pedido pedido = pedidoService.findById(id);
        if (pedido != null) {
            model.addAttribute("pedido", pedido);
            model.addAttribute("clientes", clienteService.findAll());
            return "pedido/form";
        }
        return "redirect:/pedidos";
    }

    @GetMapping("/delete/{id}")
    public String deletePedido(@PathVariable("id") Long id) {
        pedidoService.deleteById(id);
        return "redirect:/pedidos";
    }
}




