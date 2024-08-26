package com.lenguajes.service;

import com.lenguajes.domain.Proveedor;
import java.util.List;

public interface ProveedorService {
    List<Proveedor> findAll();
    Proveedor findById(Long id);
    Proveedor save(Proveedor proveedor);
    void deleteById(Long id);
}

