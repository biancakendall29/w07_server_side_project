package com.bnta.pokemon_project.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pokemons")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private Type type; // enum
    @Column
    private int level; // 1 - 100
    @ManyToMany
    @JoinTable(
            name = "trainers_pokemons",
            joinColumns = {@JoinColumn(name = "pokemon_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "trainer_id", nullable = false)}
    )
    @JsonIgnoreProperties({"pokemons"})
    private List<Trainer> trainers;
    //need to add code for enum in this class for derived query

//    CONSTRUCTORS
    public Pokemon(String name, Type type, int level, List<Trainer> trainers) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.trainers = trainers;
    }

    public Pokemon() {}

//GETTERS & SETTERS
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }

    //    public void assignTrainer(Trainer trainer) {
//        this.trainer = trainer;
//    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", level=" + level +
                ", trainers=" + trainers +
                '}';
    }
}
