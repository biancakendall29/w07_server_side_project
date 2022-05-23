package com.bnta.pokemon_project.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Trainer {

    private Long id;
    private String name;
    private LocalDate dob;
    private List<Pokemon> pokemon;
    private List<Gym> gym_badges;

    public Trainer(String name, LocalDate dob) {
        this.name = name;
        this.dob = dob;
        this.pokemon = new ArrayList<>();
        this.gym_badges = new ArrayList<>();
    }

    public Trainer() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

    public List<Gym> getGym_badges() {
        return gym_badges;
    }

    public void setGym_badges(List<Gym> gym_badges) {
        this.gym_badges = gym_badges;
    }
}
