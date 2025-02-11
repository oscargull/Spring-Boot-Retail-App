package com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.destino;

import java.util.List;
import java.util.Optional;

import com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.pedido.Pedido;
import org.springframework.stereotype.Service;

@Service
public interface DestinoServiceInterface {
    public Destino crearDestino(Destino destino);

    public List<Destino> listarDestinos();

    public Optional<Destino> obtenerPorId(Long id);

    public void eliminarDestino(Long id);
    
}
