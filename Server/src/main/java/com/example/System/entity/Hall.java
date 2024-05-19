package com.example.System.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "hall")
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "hall", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecordCenter> records;

    @Column(nullable = false)
    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}

    @Column(nullable = false)
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public List<RecordCenter> getRecords() {
        return records;
    }

    public void setRecords(List<RecordCenter> records) {
        this.records = records;
    }

}
