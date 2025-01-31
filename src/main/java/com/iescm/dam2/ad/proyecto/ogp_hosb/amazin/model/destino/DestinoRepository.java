package com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.destino;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.pedido.Pedido;



@Repository
public interface DestinoRepository extends JpaRepository<Destino, Long>{

}
