package com.lenguajes.controller;


import com.lenguajes.domain.Producto;
import com.lenguajes.service.ProductoService;
import com.lenguajes.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String listarProductos(Model model) {
        List<Producto> productos = productoService.findAll();
        model.addAttribute("productos", productos);
        return "producto/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeRegistro(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("categorias", categoriaService.findAll());
        return "producto/formulario";
    }

    @PostMapping
    public String guardarProducto(@ModelAttribute("producto") Producto producto) {
        productoService.save(producto);
        return "redirect:/productos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEdicion(@PathVariable("id") Long id, Model model) {
        Producto producto = productoService.findById(id);
        if (producto != null) {
            model.addAttribute("producto", producto);
            model.addAttribute("categorias", categoriaService.findAll());
            return "producto/formulario";
        } else {
            return "redirect:/productos";
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable("id") Long id) {
        productoService.deleteById(id);
        return "redirect:/productos";
    }

    @GetMapping("/{id}")
    public String verDetallesProducto(@PathVariable("id") Long id, Model model) {
        Producto producto = productoService.findById(id);
        if (producto != null) {
            model.addAttribute("producto", producto);
            return "producto/detalle";
        } else {
            return "redirect:/productos";
        }
    }
}


