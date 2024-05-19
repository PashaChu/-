package com.example.System.entity;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "record")
public class RecordCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "coach_id")
    private Coach coach;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;

    @ManyToOne
    @JoinColumn(name = "training_id")
    private Training training;

    @Column(nullable = false)
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    @Column(nullable = false)
    public Date getDate() {return date;}
    public void setDate(Date date) {this.date = date;}

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    public Coach getCoach() {
        return coach;
    }
    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Hall getHall() {
        return hall;
    }
    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Training getTraining() {
        return training;
    }
    public void setTraining(Training training) {
        this.training = training;
    }
}

