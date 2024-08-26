/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lenguajes.controller;

import com.lenguajes.domain.Proveedor;
import com.lenguajes.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    // aca see listan los provedores
    @GetMapping
    public String listarProveedores(Model model) {
        model.addAttribute("proveedores", proveedorService.findAll());
        return "proveedores/listar";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeCrear(Model model) {
        model.addAttribute("proveedor", new Proveedor());
        return "proveedores/formulario"; 
    }

    @PostMapping
    public String guardarProveedor(@ModelAttribute("proveedor") Proveedor proveedor) {
        proveedorService.save(proveedor);
        return "redirect:/proveedores";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model model) {
        Proveedor proveedor = proveedorService.findById(id);
        if (proveedor == null) {
            return "redirect:/proveedores";
        }
        model.addAttribute("proveedor", proveedor);
        return "proveedores/formulario"; 
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProveedor(@PathVariable Long id) {
        proveedorService.deleteById(id);
        return "redirect:/proveedores";
    }
}


