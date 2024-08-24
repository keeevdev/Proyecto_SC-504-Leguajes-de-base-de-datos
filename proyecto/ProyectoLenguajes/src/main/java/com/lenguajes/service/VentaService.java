package com.lenguajes.service;

import java.util.List;
import java.util.Optional;

import com.lenguajes.domain.Venta;

public interface VentaService {
    List<Venta> findAll();
    Optional<Venta> findById(Long idVenta);
    Venta save(Venta venta);
    void deleteById(Long idVenta);

    Double obtenerTotalVentasCliente(Long idCliente);
}