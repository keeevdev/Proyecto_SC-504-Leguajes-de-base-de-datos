package com.lenguajes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lenguajes.domain.Producto;
import com.lenguajes.service.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public String listProductos(Model model) {
        model.addAttribute("productos", productoService.findAll());
        return "producto/producto";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Producto getProducto(@PathVariable("id") Long id) {
        return productoService.findById(id).orElse(null);
    }

    @GetMapping("/add")
    public String addProductoForm(Model model) {
        model.addAttribute("producto", new Producto());
        return "producto/add";
    }

    @PostMapping("/add")
    public String addProducto(@ModelAttribute Producto producto) {
        productoService.save(producto);
        return "redirect:/producto";
    }

    @GetMapping("/edit/{id}")
    public String editProductoForm(@PathVariable("id") Long id, Model model) {
        Producto producto = productoService.findById(id).orElse(null);
        if (producto != null) {
            model.addAttribute("producto", producto);
            return "producto/edit";
        }
        return "redirect:/producto";
    }

    @PostMapping("/edit/{id}")
    public String editProducto(@PathVariable("id") Long id, @ModelAttribute Producto producto) {
        producto.setIdProducto(id);
        productoService.save(producto);
        return "redirect:/producto";
    }

    @GetMapping("/delete/{id}")
    public String deleteProducto(@PathVariable("id") Long id) {
        productoService.deleteById(id);
        return "redirect:/producto";
    }
}
