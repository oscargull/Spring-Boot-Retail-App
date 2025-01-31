package com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.almacen;

import java.util.List;
import java.util.Optional;

import com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.producto.Producto;

public interface AlmacenServiceInterface {

    public Almacen crearAlmacen(Almacen almacen);
    public Almacen actualizarAlmacen(Long id, Producto almacenActualizado);
    public void eliminarAlmacen(Long id);

    public List<Producto> listarAlmacenes();
    public List<Producto> listarPorCapacidadMaxima(String categoria);

    public Optional<Producto> obtenerPorId(Long id);

}
