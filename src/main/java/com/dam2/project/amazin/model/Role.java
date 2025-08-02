package com.dam2.project.amazin.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;
import org.springframework.data.util.QTypeContributor;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="roles")
public class Role/* implements GrantedAuthority */{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "role")
    private List<User> users = new ArrayList<>();

    @ManyToMany
    private Set<Operation> operations = new HashSet<>();

    /*@Override
    public String getAuthority() {
        return "ROLE_" + name;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
