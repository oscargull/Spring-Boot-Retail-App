package com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.pedido;

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

        public List<Pedido> searchPedidosById(Long pedidoId) {
        if (pedidoId != null) {
            return pedidoRepository.findByPedidoId(pedidoId);
        } else {
            return new ArrayList<>();  // Return an empty list if no pedido_id is provided
        }
    }

    // Find Pedido by ID
    public Pedido findPedidoById(Long pedidoId) {
        return pedidoRepository.findById(pedidoId).orElse(null);
    }

    // Save or update Pedido
    public void save(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    // Delete Pedido by ID
    public void delete(Long id) {
        pedidoRepository.deleteById(id);
    }
}
