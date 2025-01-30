package com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

    @Query(value = "SELECT a FROM Almacenes a WHERE capacidad_max>:capacidad_max",nativeQuery = true)
    List<ALmacen> buscarPorCapacidadMaxima (@Param("capacidad_max") Integer capcidad_max);
}
