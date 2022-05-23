package com.bnta.pokemon_project.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gyms")
public class Gym {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToMany //todo: finish typing rest of code for this relationship & JSON
    private List<Trainer> trainers;

    @OneToOne
    @JoinColumn(name = "gym_leader_id", referencedColumnName = "id") //double check this later
    private GymLeader gymLeader;

//    CONSTRUCTORS
    public Gym(String name, GymLeader gymLeader) {
        this.name = name;
        this.trainers = new ArrayList<>();
        this.gymLeader = gymLeader;
    }

    public Gym () {}

//    GETTERS & SETTERS

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }

    public GymLeader getGymLeader() {
        return gymLeader;
    }

    public void setGymLeader(GymLeader gymLeader) {
        this.gymLeader = gymLeader;
    }
}
