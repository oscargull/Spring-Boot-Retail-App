package com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.destino;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface DestinoServiceInterface {

    public List<Destino> listarDestinos();

    public Optional<Destino> obtenerPorId(Long id);
    
}
