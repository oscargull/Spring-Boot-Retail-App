package com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query("SELECT p FROM Producto p WHERE p.categoria =:categoria")
    List<Producto> buscarPorCategoria(@Param("categoria") String categoria);



}
