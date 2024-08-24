package com.lenguajes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lenguajes.domain.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}