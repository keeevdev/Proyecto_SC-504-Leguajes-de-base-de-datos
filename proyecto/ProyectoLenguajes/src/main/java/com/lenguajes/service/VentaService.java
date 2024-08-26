package com.lenguajes.service;

import com.lenguajes.domain.Venta;

import java.util.List;

public interface VentaService {
    List<Venta> findAll();
    Venta findById(Long id);
    Venta save(Venta venta);
    void deleteById(Long id);
}


