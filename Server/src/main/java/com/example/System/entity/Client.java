package com.example.System.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String surname; //фамилия
    private String name; // имя
    private String patronymic; //отчество
    private String login;
    private String password;
    private String telephone;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecordCenter> records;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(nullable = false)
    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}

    @Column(nullable = false)
    public  String getSurname() { return surname; }
    public  void setSurname(String surname) {this.surname = surname;}

    @Column(nullable = false)
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    @Column(nullable = false)
    public  String getPatronymic() {return patronymic;}
    public  void setPatronymic(String patronymic) {this.patronymic = patronymic;}


    @Column(nullable = false)
    public  String getLogin() { return login; }
    public  void setLogin(String login) {this.login = login;}

    @Column(nullable = false)
    public  String getPassword() { return password; }
    public  void setPassword(String password) {this.password = password;}

    @Column(length = 11, nullable = false)
    public String getTelephone() {return telephone;}
    public void setTelephone(String telephone) {this.telephone = telephone;}

    public List<RecordCenter> getRecords() {
        return records;
    }
    public void setRecords(List<RecordCenter> records) {
        this.records = records;
    }

    public String getFIO(){return surname + " " + name + " " + patronymic;}

    public Role getRole() { return role;}
    public void setRole(Role role) { this.role = role;}

}
