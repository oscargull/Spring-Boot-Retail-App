package com.dam2.project.amazin.model.almacen;

import java.util.List;
import java.util.Optional;


public interface AlmacenServiceInterface {

    public Almacen crearAlmacen(Almacen almacen);
    public Almacen actualizarAlmacen(Long id, Almacen almacenActualizado);
    public void eliminarAlmacen(Long id);

    public List<Almacen> listarAlmacenes();
    public List<Almacen> listarPorCapacidadMaxima();

    public Optional<Almacen> obtenerPorId(Long id);

    /*public List<Long> getAlmacenIds();
    public List<String> getAlmacenNombres();*/

}
