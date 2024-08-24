package com.lenguajes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lenguajes.domain.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
}