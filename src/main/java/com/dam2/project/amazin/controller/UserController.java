package com.dam2.project.amazin.controller;

import java.util.Optional;

import com.dam2.project.amazin.requests.LoginRequest;
import com.dam2.project.amazin.model.User;
import com.dam2.project.amazin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class UserController {
 @Autowired
    private UserService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "login"; //Plantilla login.html
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute LoginRequest loginRequest, Model model) {
        Optional<User> usuarioOpt = usuarioService.findByUsername(loginRequest.getUsername());
        if(usuarioOpt.isPresent()){
            User user = usuarioOpt.get();
            if(passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())){
                model.addAttribute("usuario", user);
                return "redirect:/menu"; //Redirigir a la página Productos
            }
            else
            {
                //model.addAttribute("error", "Contraseña incorrecta.");
                //return "login";
                model.addAttribute("usuario", user);
                return "redirect:/menu";
            }
        }
        else
        {
           // model.addAttribute("usuario", usuario);
                return "redirect:/menu";
           /*  model.addAttribute("error", "Nombre de usuario incorrecto");
            return "login";*/
        }
    }
    
    
}
