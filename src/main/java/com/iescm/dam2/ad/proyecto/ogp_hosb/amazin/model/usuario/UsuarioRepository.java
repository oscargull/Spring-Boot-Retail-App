package com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findByNomUsuario(String nom_usuario);
}
