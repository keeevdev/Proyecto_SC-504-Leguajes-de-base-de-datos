package com.lenguajes.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenguajes.dao.VentaRepository;
import com.lenguajes.domain.Venta;
import com.lenguajes.service.VentaService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Venta> findAll() {
        return ventaRepository.findAll();
    }

    @Override
    public Optional<Venta> findById(Long idVenta) {
        return ventaRepository.findById(idVenta);
    }

    @Override
    public Venta save(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public void deleteById(Long idVenta) {
        ventaRepository.deleteById(idVenta);
        
    }

    @Override
    public Double obtenerTotalVentasCliente(Long idCliente) {
        return (Double) entityManager.createNativeQuery("SELECT obtener_total_ventas_cliente(:idCliente)")
                                     .setParameter("idCliente", idCliente)
                                     .getSingleResult();
    }
}