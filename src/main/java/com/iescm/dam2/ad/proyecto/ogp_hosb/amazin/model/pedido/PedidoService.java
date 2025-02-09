package com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService implements PedidoServiceInterface{
    
    @Autowired
    private PedidoRepository repository;

    
    @Override
    public Pedido crearPedido(Pedido pedido) {
        return repository.save(pedido);
    }

    @Override
    public Pedido actualizarPedido(Long id, Pedido pedidoActualizado) {
        return repository.findById(id).map(pedido ->{
            pedido.setEstado(pedidoActualizado.getEstado());
            pedido.setDescripcion(pedidoActualizado.getDescripcion());
            pedido.setFecha_de_llegada(pedidoActualizado.getFecha_de_llegada());
            pedido.setFecha_de_pedido(pedidoActualizado.getFecha_de_pedido());
            pedido.setProducto_id(pedidoActualizado.getProducto_id());
            pedido.setDestino_id(pedidoActualizado.getDestino_id());
            pedido.setAlmacen_id(pedidoActualizado.getAlmacen_id());
            return repository.save(pedido);
        }).orElse(null);
    }

    @Override
    public void eliminarPedido(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Pedido> listarPedidoss() {
        return repository.findAll();
    }

    @Override
    public List<Pedido> listarPorEstado(String estado) {
        return repository.buscarPorEstado(estado);
    }

    @Override
    public List<Pedido> listarPorAlmacen(Long almacen_id) {
        return repository.buscarPorAlmacen(almacen_id);
    }

    @Override
    public List<Pedido> listarPorDestino(Long destino_id) {
        return repository.buscarPorDestino(destino_id);
    }


    @Override
    public Optional<Pedido> obtenerPorId(Long id) {
        return repository.findById(id);
    }

        public Pedido searchPedidosById(Long pedidoId) {
        Pedido ped;
        if (pedidoId != null) {
            ped = repository.findById(pedidoId).orElse(null);
        } else {
             ped = null;
        }
            return ped;
        }

    // Find Pedido by ID
    public Pedido findPedidoById(Long pedido_id) {
        return repository.findById(pedido_id).orElse(null);
    }

    // Save or update Pedido
    public void save(Pedido pedido) {
        repository.save(pedido);
    }

    // Delete Pedido by ID
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
