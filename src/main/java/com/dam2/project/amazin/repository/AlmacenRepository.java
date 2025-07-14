package com.dam2.project.amazin.repository;

import com.dam2.project.amazin.model.Almacen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AlmacenRepository extends JpaRepository<Almacen, Long>{

    /*@Query(value= "SELECT almacen_id FROM Almacenes", nativeQuery = true)
    List<Long> getAlmacenIds();

   @Query(value = "SELECT nombre FROM Almacenes",nativeQuery=true)
    List<String> getAlmacenNombres();*/

    @Query("SELECT a FROM Almacen a ORDER BY a.capacidad_max DESC")
    List<Almacen> buscarPorCapacidadMaxima();

}
