package com.lenguajes.controller;

import com.lenguajes.domain.Venta;
import com.lenguajes.service.VentaService;
import com.lenguajes.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public String listarVentas(Model model) {
        List<Venta> ventas = ventaService.findAll();
        model.addAttribute("ventas", ventas);
        return "venta/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeRegistro(Model model) {
        model.addAttribute("venta", new Venta());
        model.addAttribute("pedidos", pedidoService.findAll());
        return "venta/formulario";
    }

    @PostMapping
    public String guardarVenta(@ModelAttribute("venta") Venta venta) {
        ventaService.save(venta);
        return "redirect:/ventas";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEdicion(@PathVariable("id") Long id, Model model) {
        Venta venta = ventaService.findById(id);
        if (venta != null) {
            model.addAttribute("venta", venta);
            model.addAttribute("pedidos", pedidoService.findAll());
            return "venta/formulario";
        } else {
            return "redirect:/ventas";
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarVenta(@PathVariable("id") Long id) {
        ventaService.deleteById(id);
        return "redirect:/ventas";
    }

    @GetMapping("/{id}")
    public String verDetallesVenta(@PathVariable("id") Long id, Model model) {
        Venta venta = ventaService.findById(id);
        if (venta != null) {
            model.addAttribute("venta", venta);
            return "venta/detalle";
        } else {
            return "redirect:/ventas";
        }
    }
}





