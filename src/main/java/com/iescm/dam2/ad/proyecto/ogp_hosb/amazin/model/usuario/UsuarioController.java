package com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.usuario;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class UsuarioController {
 @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "login"; //Plantilla login.html
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute LoginRequest loginRequest, Model model) {
        Optional<Usuario> usuarioOpt = usuarioService.findByNomUsuario(loginRequest.getNomUsuario());
        if(usuarioOpt.isPresent()){
            Usuario usuario = usuarioOpt.get();
            if(passwordEncoder.matches(loginRequest.getPassw(), usuario.getPassw())){
                model.addAttribute("usuario", usuario);
                return "redirect:/productos"; //Redirigir a la página Productos
            }
            else
            {
                model.addAttribute("error", "Contraseña incorrecta.");
                return "login";
            }
        }
        else
        {
            model.addAttribute("error", "Nombre de usuario incorrecto");
            return "login";
        }
    }
    
    
}
