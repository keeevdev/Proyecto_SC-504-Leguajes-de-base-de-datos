package com.lenguajes.impl;

import com.lenguajes.dao.PedidoRepository;
import com.lenguajes.domain.Pedido;
import com.lenguajes.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> findById(Long idPedido) {
        return pedidoRepository.findById(idPedido);
    }

    @Override
    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public void deleteById(Long idPedido) {
        pedidoRepository.deleteById(idPedido);
    }
}
