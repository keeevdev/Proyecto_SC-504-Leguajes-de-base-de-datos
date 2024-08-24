package com.lenguajes.controller;

import com.lenguajes.domain.Cliente;
import com.lenguajes.service.ClienteService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String listClientes(Model model) {
        model.addAttribute("clientes", clienteService.findAll());
        return "cliente/list";
    }

    @GetMapping("/{idCliente}")
    @ResponseBody
    public Optional<Cliente> getCliente(@PathVariable("idCliente") Long idCliente) {
        return clienteService.findById(idCliente);
    }

    @PostMapping("/add")
    public String addCliente(@ModelAttribute Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/cliente";
    }

    @PostMapping("/edit/{idCliente}")
    public String editCliente(@PathVariable("idCliente") Long idCliente, @ModelAttribute Cliente cliente) {
        cliente.setIdCliente(idCliente); // Usa setIdCliente en lugar de setId
        clienteService.save(cliente);
        return "redirect:/cliente";
    }

    @GetMapping("/delete/{idCliente}")
    public String deleteCliente(@PathVariable("idCliente") Long idCliente) {
        clienteService.deleteById(idCliente);
        return "redirect:/cliente";
    }
}

