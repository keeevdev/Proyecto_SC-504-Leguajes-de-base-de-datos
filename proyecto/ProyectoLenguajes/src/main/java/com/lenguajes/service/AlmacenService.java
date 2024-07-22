package com.lenguajes.service;

import com.lenguajes.domain.Almacen;

import java.util.List;
import java.util.Optional;

public interface AlmacenService {
    List<Almacen> findAll();
    Optional<Almacen> findById(Long id);
    Almacen save(Almacen almacen);
    void deleteById(Long id);
}

