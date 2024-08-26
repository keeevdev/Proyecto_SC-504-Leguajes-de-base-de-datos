package com.lenguajes.service;

import com.lenguajes.domain.Categoria;

import java.util.List;

public interface CategoriaService {
    List<Categoria> findAll();
    Categoria findById(Long id);
    Categoria save(Categoria categoria);
    void deleteById(Long id);
}
