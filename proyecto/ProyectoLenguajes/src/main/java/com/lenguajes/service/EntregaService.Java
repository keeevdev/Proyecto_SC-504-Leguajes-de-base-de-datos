package com.lenguajes.service;

import com.lenguajes.domain.Entrega;
import java.util.List;
import java.util.Optional;

public interface EntregaService {
    List<Entrega> findAll();
    Optional<Entrega> findById(Long idEntrega);  
    Entrega save(Entrega entrega);
    void deleteById(Long idEntrega);  
}
