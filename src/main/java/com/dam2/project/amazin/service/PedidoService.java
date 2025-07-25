package com.dam2.project.amazin.service;

import java.util.List;
import java.util.Optional;

import com.dam2.project.amazin.model.Pedido;
import com.dam2.project.amazin.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService implements PedidoServiceInterface {
    
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
    public List<Pedido> listarPorEstado(Pedido.Estado estado) {
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

    public Pedido findPedidoById(Long pedido_id) {
        return repository.findById(pedido_id).orElse(null);
    }

    public void save(Pedido pedido) {
        repository.save(pedido);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
