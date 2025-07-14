package com.dam2.project.amazin.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Blob;
import java.util.Set;

@Entity
@Table(name="productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long producto_id;

    @NotNull(message = "El nombre no puede ser nulo")
    @Size(min = 3, max = 50, message = "El nombre solo puede tener entre 3 y 50 caracteres")
    @Column(unique = true)
    private String nombre;

    @Size(max = 255, message = "Descripción máximo 255 caracteres.")
    private String descripcion;

    private String categoria;

    @NotNull(message = "El precio no puede ser nulo")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor que 0")
    private Double precio;

    private Integer stock;

    @Lob
    private Blob imagen;

    @ManyToMany
    @JoinTable(
            name = "producto_almacen",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "almacen_id")
    )
    private Set<Almacen> almacenes;


    public Set<Almacen> getAlmacenes() {
        return almacenes;
    }

    public void setAlmacenes(Set<Almacen> almacenes) {
        this.almacenes = almacenes;
    }

    public Long getProducto_id() {
        return producto_id;
    }
    public void setProducto_id(Long producto_id) {
        this.producto_id = producto_id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public Blob getImagen() {
        return imagen;
    }
    public void setImagen(Blob imagen) {
        this.imagen = imagen;
    }



}
