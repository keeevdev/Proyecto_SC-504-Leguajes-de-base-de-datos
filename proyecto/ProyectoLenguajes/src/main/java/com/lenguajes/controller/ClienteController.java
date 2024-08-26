package com.lenguajes.controller;

import com.lenguajes.domain.Cliente;
import com.lenguajes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String listClientes(Model model) {
        model.addAttribute("clientes", clienteService.findAll());
        return "clientes/list";
    }

    @GetMapping("/create")
    public String createClienteForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clientes/form";
    }

    @PostMapping("/save")
    public String saveCliente(@ModelAttribute Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/edit/{id}")
    public String editClienteForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("cliente", clienteService.findById(id));
        return "clientes/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteCliente(@PathVariable("id") Long id) {
        clienteService.deleteById(id);
        return "redirect:/clientes";
    }
}

