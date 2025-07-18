package com.dam2.project.amazin.repository;

import java.util.List;


import com.dam2.project.amazin.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

    @Query("SELECT p FROM Pedido p WHERE p.estado =:estado")
    List<Pedido> buscarPorEstado(@Param("estado") Pedido.Estado estado);

    @Query(value = "SELECT p FROM Pedido WHERE p.almacen_id =:almacen_id", nativeQuery=true)
    List<Pedido> buscarPorAlmacen(@Param("almacen_id") Long almacen_id);

    @Query(value ="SELECT p FROM Pedido WHERE p.destino_id =:destino_id", nativeQuery=true)
    List<Pedido> buscarPorDestino(@Param("destino_id") Long destino_id);

    //cambiar destino

//    List<Pedido> findByPedidoId(Long pedido_id);
}
