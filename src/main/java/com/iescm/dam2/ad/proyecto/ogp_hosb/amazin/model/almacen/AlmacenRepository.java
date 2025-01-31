package com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.almacen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.pedido.Pedido;

import java.util.List;


@Repository
public interface AlmacenRepository extends JpaRepository<Almacen, Long>{

    @Query(value = "SELECT a FROM Almacenes a WHERE capacidad_max>:capacidad_max",nativeQuery = true)
    List<Almacen> buscarPorCapacidadMaxima (@Param("capacidad_max") Integer capcidad_max);


}
