package com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.destino;

import java.util.List;
import java.util.Optional;

import com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.pedido.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DestinoService implements DestinoServiceInterface{

    @Autowired
    DestinoRepository repository;

    @Override
    public Destino crearDestino(Destino destino) {
        return repository.save(destino);
    }

    @Override
    public List<Destino> listarDestinos() {
        return repository.findAll();
    }

    @Override
    public Optional<Destino> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public void eliminarDestino(Long id) {
        repository.deleteById(id);
    }




}
