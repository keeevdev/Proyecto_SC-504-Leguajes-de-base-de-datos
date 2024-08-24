package com.lenguajes.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lenguajes.domain.Venta;
import com.lenguajes.service.VentaService;

@Controller
@RequestMapping("/venta")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public String listVentas(Model model) {
        model.addAttribute("ventas", ventaService.findAll());
        return "venta/venta";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Venta> getVenta(@PathVariable("id") Long id) {
        return ventaService.findById(id);
    }

    @PostMapping("/add")
    public String addVenta(@ModelAttribute Venta venta) {
        ventaService.save(venta);
        return "redirect:/venta";
    }

    @PostMapping("/edit/{id}")
    public String editVenta(@PathVariable("id") Long id, @ModelAttribute Venta venta) {
        venta.setIdVenta(id);
        ventaService.save(venta);
        return "redirect:/venta";
    }

    @GetMapping("/delete/{id}")
    public String deleteVenta(@PathVariable("id") Long id) {
        ventaService.deleteById(id);
        return "redirect:/venta";
    }

    @GetMapping("/totalVentasCliente/{idCliente}")
    @ResponseBody
    public Double getTotalVentasCliente(@PathVariable("idCliente") Long idCliente) {
    return ventaService.obtenerTotalVentasCliente(idCliente);
}
}
