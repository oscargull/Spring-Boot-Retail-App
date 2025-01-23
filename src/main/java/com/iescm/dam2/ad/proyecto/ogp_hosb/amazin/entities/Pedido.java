package com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pedido_id;

    private Boolean enviado;

    private Date fecha_de_llegada;

    @Size(max = 255, message = "Descripción máximo 255 caracteres.")
    private String descripcion;

    @NotNull(message = "El almacén no puede ser nulo")
    private Long almacen_id;
    
    @NotNull(message = "El producto no puede ser nulo")
    private Long producto_id;

    
    public Long getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(Long pedido_id) {
        this.pedido_id = pedido_id;
    }

    public Boolean getEnviado() {
        return enviado;
    }

    public void setEnviado(Boolean enviado) {
        this.enviado = enviado;
    }

    public Date getFecha_de_llegada() {
        return fecha_de_llegada;
    }

    public void setFecha_de_llegada(Date fecha_de_llegada) {
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

    
}
