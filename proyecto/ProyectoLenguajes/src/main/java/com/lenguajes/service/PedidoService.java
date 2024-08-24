package com.lenguajes.service;

import com.lenguajes.domain.Pedido;
import java.util.List;
import java.util.Optional;

public interface PedidoService {
    List<Pedido> findAll();
    Optional<Pedido> findById(Long idPedido);
    Pedido save(Pedido pedido);
    void deleteById(Long idPedido);
}
