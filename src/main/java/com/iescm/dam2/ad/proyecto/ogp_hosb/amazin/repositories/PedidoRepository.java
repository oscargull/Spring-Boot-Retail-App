package com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.entities.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

    @Query("SELECT p FROM Pedido p WHERE p.estado =:estado")
    List<Pedido> buscarPorEstado(@Param("estado") String estado);

    @Query("SELECT p FROM Pedido WHERE p.almacen_id =:almacen_id")
    List<Pedido> buscarPorAlmacen(@Param("almacen_id") String almacen_id);

    @Query("SELECT p FROM Pedido WHERE p.destino_id =:destino_id")
    List<Pedido> buscarPorDestino(@Param("destino_id") String destino_id);
}