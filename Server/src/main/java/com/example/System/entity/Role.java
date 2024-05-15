package com.example.System.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // номер роли
    private String role; // роль

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Client> client;

    @Column(nullable = false)
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    @Column(nullable = false)
    public String getRole() {return role;}
    public void setRole(String role) {this.role = role;}

    public List<Client> getUsers() {
        return client;
    }
    public void setUsers(List<Client> client) {
        this.client = client;
    }
}
