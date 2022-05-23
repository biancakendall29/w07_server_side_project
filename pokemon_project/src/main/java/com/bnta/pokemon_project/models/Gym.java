package com.bnta.pokemon_project.models;

import java.util.ArrayList;
import java.util.List;

public class Gym {
    private Long id;
    private String name;
    private List<Trainer> trainers;
    private GymLeader gymLeader;

    public Gym(String name, GymLeader gymLeader) {
        this.name = name;
        this.trainers = new ArrayList<>();
        this.gymLeader = gymLeader;
    }

    public Gym () {}

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
