package com.bnta.pokemon_project.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "trainers")
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private LocalDate dob;
    @ManyToMany(mappedBy = "trainers")
    @JsonIgnoreProperties({"trainers"})
    private List<Pokemon> pokemons;
    @ManyToMany(mappedBy = "trainers")
    @JsonIgnoreProperties({"trainers"})
    private List<Gym> gym_badges;

//    CONSTRUCTOR
    public Trainer(String name, LocalDate dob) {
        this.name = name;
        this.dob = dob;
        this.pokemons = new ArrayList<>();
        this.gym_badges = new ArrayList<>();
    }

    public Trainer() {}

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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public List<Gym> getGym_badges() {
        return gym_badges;
    }

    public void setGym_badges(List<Gym> gym_badges) {
        this.gym_badges = gym_badges;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void removePokemon(Pokemon pokemon){
        this.pokemons.remove(pokemon);
    }

    public void addGym(Gym gym_badge) {
        this.gym_badges.add(gym_badge);
    }

    public void removeGym(Gym gym_badge){
        this.gym_badges.remove(gym_badge);
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", pokemons=" + pokemons +
                ", gym_badges=" + gym_badges +
                '}';
    }
}
