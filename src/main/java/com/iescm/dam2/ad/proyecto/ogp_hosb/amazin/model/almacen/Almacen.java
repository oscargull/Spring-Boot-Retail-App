package com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.almacen;
//Quandale dingle here
import com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.producto.Producto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name="almacenes")
public class Almacen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long almacen_id;

    @NotNull(message = "No puede no tener nombre")
    @Size(min = 3, max = 50, message = "El nombre solo puede tener entre 3 y 50 caracteres")
    private String nombre;

    @NotNull(message = "Debe indicar la capacidad máxima del almacén.")
    private Integer capacidad_max;

    private Integer ocupacion;

    @Size(min = 3, max = 50, message = "El nombre solo puede tener entre 3 y 50 caracteres")
    private String direccion;

    @Size(min = 9, max = 9, message = "Número de teléfono inválido")
    private String telefono;



    @ManyToMany(mappedBy = "almacenes")
    private Set<Producto> productos;

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }

    public Long getAlmacen_id() {
        return almacen_id;
    }
    public void setAlmacen_id(Long almacen_id) {
        this.almacen_id = almacen_id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getCapacidad_max() {
        return capacidad_max;
    }
    public void setCapacidad_max(Integer capacidad_max) {
        this.capacidad_max = capacidad_max;
    }
    public Integer getOcupacion() {
        return ocupacion;
    }
    public void setOcupacion(Integer ocupacion) {
        this.ocupacion = ocupacion;
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

}
