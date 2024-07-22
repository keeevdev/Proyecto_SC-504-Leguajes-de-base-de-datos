package com.lenguajes.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Almacen {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "almacen_seq")
    @SequenceGenerator(name = "almacen_seq", sequenceName = "ALMACEN_SEQ", allocationSize = 1)
    private Long idAlmacen;

    private String nombre;
    private String direccion;
    private Integer capacidadMaxima;

    // Getters y Setters
    public Long getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(Long idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(Integer capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }
}


