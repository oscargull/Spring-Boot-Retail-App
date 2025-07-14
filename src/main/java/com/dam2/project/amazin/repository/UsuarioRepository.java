package com.dam2.project.amazin.repository;

import java.util.Optional;

import com.dam2.project.amazin.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findByNomUsuario(String nom_usuario);
}
