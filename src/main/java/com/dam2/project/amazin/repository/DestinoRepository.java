package com.dam2.project.amazin.repository;

import com.dam2.project.amazin.model.Destino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DestinoRepository extends JpaRepository<Destino, Long>{

    
}
