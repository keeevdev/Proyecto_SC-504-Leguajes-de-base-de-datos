package com.lenguajes.impl;

import com.lenguajes.dao.AlmacenRepository;
import com.lenguajes.domain.Almacen;
import com.lenguajes.service.AlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlmacenServiceImpl implements AlmacenService {

    @Autowired
    private AlmacenRepository almacenRepository;

    @Override
    public List<Almacen> findAll() {
        return almacenRepository.findAll();
    }

    @Override
    public Optional<Almacen> findById(Long id) {
        return almacenRepository.findById(id);
    }

    @Override
    public Almacen save(Almacen almacen) {
        return almacenRepository.save(almacen);
    }

    @Override
    public void deleteById(Long id) {
        almacenRepository.deleteById(id);
    }
}

