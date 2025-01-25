package com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Entity
@Table(name = "AlmacenesProductos")
public class AlmacenesProductos {

    @EmbeddedId
    private AlmacenesProductos_Id almacenes_productos_id;

    @NotNull(message = "Cantidad no puede ser nula")
    private Integer cantidad;

    public AlmacenesProductos_Id getAlmacenes_productos_id() {
        return almacenes_productos_id;
    }
    public void setAlmacenes_productos_id(AlmacenesProductos_Id almacenes_productos_id) {
        this.almacenes_productos_id = almacenes_productos_id;
    }

    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }



    @Embeddable
    public static class AlmacenesProductos_Id implements Serializable{

        @Id
        private Long almacen_id;

        @Id
        private Long producto_id;

        public AlmacenesProductos_Id(Long almacen_id, Long producto_id) {
            this.almacen_id = almacen_id;
            this.producto_id = producto_id;
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
}
