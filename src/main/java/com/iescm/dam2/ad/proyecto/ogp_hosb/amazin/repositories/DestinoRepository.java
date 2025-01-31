package com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.entities.Pedido;



@Repository
public interface DestinoRepository extends JpaRepository<Pedido, Long>{

}
