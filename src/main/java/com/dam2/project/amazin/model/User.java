package com.dam2.project.amazin.model;

import com.dam2.project.amazin.repository.ProductoRepository;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Entity
@Table(name = "usuarios")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="usuario_id")
    private int usuario_id;

    @Column(name="nom_usuario", unique = true)
    @NotNull(message = "EL nombre de usuario no puede ser nulo")
    @Size(min = 5, max = 20, message = "El nombre de usuario solo puede tener entre 2 y 20 caracteres")
    private String username;
    
    @Column(name="password")
    @NotNull(message = "La contraseña no puede ser nula")
    @Size(min = 6, max = 255, message = "La contraseña solo puede tener entre  y 255 caracteres.")
    private String password;
    
    @Column(name="nombre")
    @Size(max = 100, message = "Nombre máximo 255 caracteres.")
    private String nombre;
    
    @Column(name="email")
    @Size(max = 100, message = "Descripción máximo 255 caracteres.")
    private String email;

    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;

    //private Collection<? extends GrantedAuthority> authorities;



    public int getId_usuario() {
        return usuario_id;
    }

    public void setId_usuario(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

}
