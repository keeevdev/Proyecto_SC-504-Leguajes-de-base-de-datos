package com.lenguajes.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Column;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_generator")
    @SequenceGenerator(name="cliente_generator", sequenceName = "cliente_seq", allocationSize=1)
    @Column(name = "id_cliente")  // Especificamos el nombre de la columna en la tabla
    private Long idCliente;  // Cambiado a idCliente
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "direccion", nullable = false)
    private String direccion;
    
    @Column(name = "telefono")
    private String telefono;  // Agregado el campo telefono
    
    @Column(name = "correo_electronico")
    private String correoElectronico;

    // Getters y Setters
    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}
