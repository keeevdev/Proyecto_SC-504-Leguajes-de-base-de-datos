package com.lenguajes.service;

import java.util.List;
import java.util.Optional;

import com.lenguajes.domain.Producto;

public interface ProductoService {
    List<Producto> findAll();
    Optional<Producto> findById(Long idProducto);
    Producto save(Producto producto);
    void deleteById(Long idProducto);
}