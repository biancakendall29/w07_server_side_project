package com.bnta.pokemon_project.models;

public class GymLeader {
    private Long id;
    private String name;
    private Gym gym;

    public GymLeader(String name, Gym gym) {
        this.name = name;
        this.gym = gym;
    }

    public GymLeader () {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }
}
