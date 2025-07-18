package com.dam2.project.amazin.service;

import java.util.List;
import java.util.Optional;

import com.dam2.project.amazin.model.Almacen;
import com.dam2.project.amazin.repository.AlmacenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlmacenService implements AlmacenServiceInterface {

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
            return repository.save(almacen);
        }).orElse(null);    
    }

    @Override
    public void eliminarAlmacen(Long id) {
        repository.deleteById(id);
    }


    @Override
    public List<Almacen> listarAlmacenes() {
        return repository.findAll();
    }

    @Override
    public List<Almacen> listarPorCapacidadMaxima() {
        return repository.buscarPorCapacidadMaxima();

    }

    @Override
    public Optional<Almacen> obtenerPorId(Long id) {
        return repository.findById(id);
    }

   /*  @Override
    public List<Long> getAlmacenIds() {
        return  repository.getAlmacenIds();
    }

    @Override
    public List<String> getAlmacenNombres() {
       return repository.getAlmacenNombres();
}*/

}
