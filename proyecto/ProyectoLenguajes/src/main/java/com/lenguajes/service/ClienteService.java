package com.lenguajes.service;

import com.lenguajes.domain.Cliente;
import java.util.List;

public interface ClienteService {
    List<Cliente> findAll();
    Cliente findById(Long id);
    Cliente save(Cliente cliente);
    void deleteById(Long id);
}

