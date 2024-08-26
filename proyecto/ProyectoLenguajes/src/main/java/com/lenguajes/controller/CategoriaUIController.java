package com.lenguajes.controller;

import com.lenguajes.domain.Categoria;
import com.lenguajes.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorias")
public class CategoriaUIController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", categoriaService.findAll());
        return "listarCategorias";
    }

    @GetMapping("/nueva")
    public String mostrarFormularioNuevaCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "formCategoria";
    }

    @PostMapping
    public String guardarCategoria(@ModelAttribute("categoria") Categoria categoria) {
        categoriaService.save(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarCategoria(@PathVariable("id") Long id, Model model) {
        Categoria categoria = categoriaService.findById(id);
        if (categoria != null) {
            model.addAttribute("categoria", categoria);
            return "formCategoria";
        } else {
            return "redirect:/categorias";
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCategoria(@PathVariable("id") Long id) {
        categoriaService.deleteById(id);
        return "redirect:/categorias";
    }
}
