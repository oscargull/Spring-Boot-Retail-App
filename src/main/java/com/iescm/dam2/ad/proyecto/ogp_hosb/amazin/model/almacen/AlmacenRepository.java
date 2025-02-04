package com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.almacen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AlmacenRepository extends JpaRepository<Almacen, Long>{

    @Query("SELECT a FROM Almacen a ORDER BY a.capacidad_max DESC")
    List<Almacen> buscarPorCapacidadMaxima();

}
