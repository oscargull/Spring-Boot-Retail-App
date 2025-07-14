package com.dam2.project.amazin.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "destinos")
public class Destino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long destino_id;

    @NotNull(message = "El nombre no puede ser nulo")
    @Column(unique = true)
    private String nombre;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @NotNull(message = "La distancia no puede ser nula")
    private Double distancia;

    private String direccion;


    public Long getDestino_id() {
        return destino_id;
    }

    public void setDestino_id(Long destino_id) {
        this.destino_id = destino_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public enum Tipo {
        TIENDA,
        ESCUELA,
        HOSPITAL,
        VIVIENDA,
        GIMNASIO,
        OFICINA
    }
}
