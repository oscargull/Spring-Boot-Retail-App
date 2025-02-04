package com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.usuario;

import java.util.Optional;

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
