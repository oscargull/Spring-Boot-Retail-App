package com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.repositories;

import com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {



}
