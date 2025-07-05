package com.dam2.project.amazin.model.producto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements ProductoServiceInterface{

    @Autowired
    private ProductoRepository repository;

    @Override
    public Producto crearProducto(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public Producto actualizarProducto(Long id, Producto productoActualizado) {
        return repository.findById(id).map(producto -> {
                producto.setNombre(productoActualizado.getNombre());
                producto.setDescripcion(productoActualizado.getDescripcion());
                producto.setCategoria(productoActualizado.getCategoria());
                producto.setPrecio(productoActualizado.getPrecio());
                producto.setStock(productoActualizado.getStock());
                producto.setImagen(productoActualizado.getImagen());
                return repository.save(producto);
        }).orElse(null);
    }

    @Override
    public void eliminarProducto(Long id) {
        repository.deleteById(id);
    }


    @Override
    public List<Producto> listarProductos() {
        return repository.findAll();
    }

    @Override
    public List<Producto> listarPorCategoria(String categoria) {
        return repository.buscarPorCategoria(categoria);
    }

    @Override
    public List<Producto> listarPorPrecioMayorQue(Double precio) {
        return repository.buscarPorPrecioMayorQue(precio);
    }  


    @Override
    public Optional<Producto> obtenerPorId(Long id) {
        return repository.findById(id);
    }

  
    
}
