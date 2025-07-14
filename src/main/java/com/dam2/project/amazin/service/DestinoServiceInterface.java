package com.dam2.project.amazin.service;

import java.util.List;
import java.util.Optional;

import com.dam2.project.amazin.model.Destino;
import org.springframework.stereotype.Service;

@Service
public interface DestinoServiceInterface {
    public Destino crearDestino(Destino destino);

    public List<Destino> listarDestinos();

    public Optional<Destino> obtenerPorId(Long id);

    public void eliminarDestino(Long id);
    
}
