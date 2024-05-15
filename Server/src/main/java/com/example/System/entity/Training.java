package com.example.System.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "training")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecordCenter> records;

    @Column(nullable = false)
    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}

    @Column(nullable = false)
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public List<RecordCenter> getRecords() {
        return records;
    }
    public void setRecords(List<RecordCenter> records) {
        this.records = records;
    }
}
