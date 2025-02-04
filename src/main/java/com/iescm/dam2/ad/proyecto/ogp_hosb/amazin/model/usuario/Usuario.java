package com.iescm.dam2.ad.proyecto.ogp_hosb.amazin.model.usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="usuario_id")
    private int usuario_id;

    @Column(name="nom_usuario")
    @NotNull(message = "EL nombre de usuario no puede ser nulo")
    @Size(min = 5, max = 20, message = "El nombre de usuario solo puede tener entre 2 y 20 caracteres")
    private String nomUsuario;
    
    @Column(name="passw")
    @NotNull(message = "La contraseña no puede ser nula")
    @Size(min = 6, max = 255, message = "La contraseña solo puede tener entre  y 255 caracteres.")
    private String passw;
    
    @Column(name="nombre")
    @Size(max = 100, message = "Nombre máximo 255 caracteres.")
    private String nombre;
    
    @Column(name="email")
    @Size(max = 100, message = "Descripción máximo 255 caracteres.")
    private String email;



    public int getId_usuario() {
        return usuario_id;
    }

    public void setId_usuario(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getNom_usuario() {
        return nomUsuario;
    }

    public void setNom_usuario(String nom_usuario) {
        this.nomUsuario = nom_usuario;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
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

    
}
