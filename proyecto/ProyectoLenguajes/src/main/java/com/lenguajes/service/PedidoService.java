package com.lenguajes.service;

import com.lenguajes.domain.Pedido;
import java.util.List;

public interface PedidoService {
    List<Pedido> findAll();
    Pedido findById(Long id);
    Pedido save(Pedido pedido);
    void deleteById(Long id);
}



