package com.dam2.project.amazin.service;

import java.util.Optional;

import com.dam2.project.amazin.model.Usuario;
import com.dam2.project.amazin.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //Método que busca por nombre de usuario
    public Optional<Usuario> findByNomUsuario(String nomUsuario){
        return usuarioRepository.findByNomUsuario(nomUsuario);
    }

    //Almacenamos la contraseña cifrada al guardar el usuario
    public Usuario save(Usuario usuario){
        usuario.setPassw(passwordEncoder.encode(usuario.getPassw()));
        return usuarioRepository.save(usuario);
    }
}
