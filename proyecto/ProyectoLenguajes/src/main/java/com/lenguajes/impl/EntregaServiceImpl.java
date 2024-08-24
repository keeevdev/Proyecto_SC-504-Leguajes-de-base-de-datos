package com.lenguajes.impl;

import com.lenguajes.dao.EntregaRepository;
import com.lenguajes.domain.Entrega;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EntregaServiceImpl implements EntregaService {

    @Autowired
    private EntregaRepository entregaRepository;

    @Override
    public List<Entrega> findAll() {
        return entregaRepository.findAll();
    }

    @Override
    public Optional<Entrega> findById(Long idEntrega) {
        return entregaRepository.findById(idEntrega);
    }

    @Override
    public Entrega save(Entrega entrega) {
        return entregaRepository.save(entrega);
    }

    @Override
    public void deleteById(Long idEntrega) {
        entregaRepository.deleteById(idEntrega);
    }
}


