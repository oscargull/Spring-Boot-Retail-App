package com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.almacen;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.producto.Producto;

@Service
public class AlmacenService implements AlmacenServiceInterface{

    @Autowired
    private AlmacenRepository repository;

    @Override
    public Almacen crearAlmacen(Almacen almacen) {
        return repository.save(almacen);    
    }

    @Override
    public Almacen actualizarAlmacen(Long id, Almacen almacenActualizado) {
        return repository.findById(id).map(almacen -> {
            almacen.setNombre(almacenActualizado.getNombre());
            almacen.setCapacidad_max(almacenActualizado.getCapacidad_max());
            almacen.setOcupacion(almacenActualizado.getOcupacion());
            almacen.setDireccion(almacenActualizado.getDireccion());
            almacen.setTelefono(almacenActualizado.getTelefono());
        return repository.save(producto);
    }).orElse(null);    }

    @Override
    public void eliminarAlmacen(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarAlmacen'");
    }

    @Override
    public List<Producto> listarAlmacenes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarAlmacenes'");
    }

    @Override
    public List<Producto> listarPorCapacidadMaxima(String categoria) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarPorCapacidadMaxima'");
    }

    @Override
    public Optional<Producto> obtenerPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerPorId'");
    }

}
