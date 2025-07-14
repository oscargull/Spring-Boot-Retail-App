package com.dam2.project.amazin.service;

import com.dam2.project.amazin.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoServiceInterface {

    public Producto crearProducto(Producto producto);
    public Producto actualizarProducto(Long id, Producto productoActualizado);
    public void eliminarProducto(Long id);

    public List<Producto> listarProductos();
    public List<Producto> listarPorCategoria(String categoria);
    public List<Producto> listarPorPrecioMayorQue(Double precio);


    public Optional<Producto> obtenerPorId(Long id);

}
