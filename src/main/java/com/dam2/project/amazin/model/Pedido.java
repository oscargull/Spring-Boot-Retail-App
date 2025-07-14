package com.dam2.project.amazin.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pedido_id;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    private LocalDate fecha_de_pedido;

    private LocalDate fecha_de_llegada;

    @Size(max = 255, message = "Descripción máximo 255 caracteres.")
    private String descripcion;

    //@NotNull(message = "El almacén no puede ser nulo")
    private Long almacen_id;
    
   // @NotNull(message = "El producto no puede ser nulo")
    private Long producto_id;

    @NotNull(message = "El destino no puede ser nulo")
    private Long destino_id;

    
    public Long getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(Long pedido_id) {
        this.pedido_id = pedido_id;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public LocalDate getFecha_de_pedido() {
        return fecha_de_pedido;
    }

    public void setFecha_de_pedido(LocalDate fecha_de_pedido) {
        this.fecha_de_pedido = fecha_de_pedido;
    }

    public LocalDate getFecha_de_llegada() {
        return fecha_de_llegada;
    }

    public void setFecha_de_llegada(LocalDate fecha_de_llegada) {
        this.fecha_de_llegada = fecha_de_llegada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getAlmacen_id() {
        return almacen_id;
    }

    public void setAlmacen_id(Long almacen_id) {
        this.almacen_id = almacen_id;
    }

    public Long getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Long producto_id) {
        this.producto_id = producto_id;
    }

    public Long getDestino_id() {
        return destino_id;
    }

    public void setDestino_id(Long destino_id) {
        this.destino_id = destino_id;
    }

    public enum Estado {
        ENVIADO,
        PLANIFICADO,
        FINALIZADO,
        CANCELADO
    }
}
