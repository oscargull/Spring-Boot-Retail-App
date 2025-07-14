package com.dam2.project.amazin.service;

import com.dam2.project.amazin.model.Pedido;

import java.util.List;
import java.util.Optional;


public interface PedidoServiceInterface {
     public Pedido crearPedido(Pedido pedido);
    public Pedido actualizarPedido(Long id, Pedido pedidoActualizado);
    public void eliminarPedido(Long id);

    public List<Pedido> listarPedidoss();
    public List<Pedido> listarPorEstado(Pedido.Estado estado);
    public List<Pedido> listarPorAlmacen(Long almacen_id);
    public List<Pedido> listarPorDestino(Long destino_id);

    public Optional<Pedido> obtenerPorId(Long id);
}
