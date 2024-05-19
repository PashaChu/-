package com.example.System.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "coach")
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String surname; //фамилия
    private String name; // имя
    private String patronymic; //отчество

    @OneToMany(mappedBy = "coach", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecordCenter> records;

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

    public List<RecordCenter> getRecords() {
        return records;
    }
    public void setRecords(List<RecordCenter> records) {
        this.records = records;
    }

    public String getFIO(){return surname + " " + name + " " + patronymic;}

}
