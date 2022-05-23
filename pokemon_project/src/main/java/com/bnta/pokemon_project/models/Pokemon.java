package com.bnta.pokemon_project.models;

import javax.persistence.*;

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
    @ManyToOne
    private Trainer trainer;

    public Pokemon(String name, Type type, int level, Trainer trainer) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.trainer = trainer;
    }

    public Pokemon() {}

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

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
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
                ", trainer=" + trainer +
                '}';
    }
}
