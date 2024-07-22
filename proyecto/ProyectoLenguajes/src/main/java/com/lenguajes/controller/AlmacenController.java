package com.lenguajes.controller;


import com.lenguajes.domain.Almacen;
import com.lenguajes.service.AlmacenService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/almacen")
public class AlmacenController {

    @Autowired
    private AlmacenService almacenService;

    @GetMapping
    public String listAlmacenes(Model model) {
        model.addAttribute("almacenes", almacenService.findAll());
        return "almacen/list";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Almacen> getAlmacen(@PathVariable("id") Long id) {
        return almacenService.findById(id);
    }

    @PostMapping("/add")
    public String addAlmacen(@ModelAttribute Almacen almacen) {
        almacenService.save(almacen);
        return "redirect:/almacen";
    }

    @PostMapping("/edit/{id}")
    public String editAlmacen(@PathVariable("id") Long id, @ModelAttribute Almacen almacen) {
        almacen.setIdAlmacen(id);
        almacenService.save(almacen);
        return "redirect:/almacen";
    }

    @GetMapping("/delete/{id}")
    public String deleteAlmacen(@PathVariable("id") Long id) {
        almacenService.deleteById(id);
        return "redirect:/almacen";
    }
}

