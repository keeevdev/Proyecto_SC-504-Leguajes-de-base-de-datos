package com.lenguajes.controller;

import com.lenguajes.model.Cliente;
import com.lenguajes.service.ClienteService;
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
        return "clientes/list";
        
    }
    @GetMapping("/{id}")
    @ResponseBody
    public Cliente getCliente(@PathVariable("id") Long id) {
     return clienteService.findById(id);
     
    }
    @PostMapping("/{id}/add")
    public String addCliente(@ModelAttribute Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/cliente";
        
    }
    @PostMapping
    public String saveCliente(@ModelAttribute Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/{id}")
    public String showCliente(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.findById(id);
        model.addAttribute("cliente", cliente);
        return "cliente_detail";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Object cliente = clienteService.findById(id);
        model.addAttribute("cliente", cliente);
        return "cliente_form";
    }

    @PostMapping("/{id}")
    public String updateCliente(@PathVariable Long id, @ModelAttribute Cliente cliente) {
        cliente.setId(id);
        clienteService.save(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/{id}/delete")
    public String deleteCliente(@PathVariable Long id) {
        clienteService.deleteById(id);
        return "redirect:/clientes";
    }
}