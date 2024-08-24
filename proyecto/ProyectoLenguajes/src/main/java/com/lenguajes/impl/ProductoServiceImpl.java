package com.lenguajes.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenguajes.dao.ProductoRepository;
import com.lenguajes.domain.Producto;
import com.lenguajes.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findById(Long idProducto) {
        return productoRepository.findById(idProducto);
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void deleteById(Long idProducto) {
        productoRepository.deleteById(idProducto);
    }
}
