package com.bnta.pokemon_project.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Entity
@Table(name = "gyms")
public class Gym{

//      PROPERTIES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @ManyToMany
    @JoinTable(
            name = "trainers_gyms",
            joinColumns = {@JoinColumn(name = "gym_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "trainer_id", nullable = false)}
    )
    @JsonIgnoreProperties({"gym_badges"})
    private List<Trainer> trainers;
    @OneToOne(mappedBy = "gym")
    @JsonIgnoreProperties({"gym"})
    private GymLeader gymLeader;

//    CONSTRUCTORS
    public Gym(String name, List<Trainer> trainers) {
        this.name = name;
        this.trainers = trainers;
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

    // BATTLE
    // Gym controller contains a POST request that calls addBattle
    public void addBattle(Battle battle, Trainer[] trainers, Pokemon[] pokemons) throws IOException {
        String winner;
        Pokemon winnerPokemon;
        // calls method in Battle class which calculates by how much the winning pokemon should level up
        int increase = battle.calculateLevelIncrease(pokemons, battle.getResult());
        // creates file to write a log of battles
        File file = new File("src//textFiles/battleLog.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(file, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        printWriter.println("[");
        printWriter.println("   Location: " + battle.getLocation());
        printWriter.println("   Date: " + battle.getDate());
        printWriter.println("   Trainer 1: " + trainers[0].getName() + " WITH Pokemon: " + pokemons[0].getName() + " of original level:  " + pokemons[0].getLevel());
        printWriter.println("   Trainer 2: " + trainers[1].getName() + " WITH Pokemon: " + pokemons[1].getName() + " of original level:  " + pokemons[1].getLevel());

        // if result is inserted as true, trainer1 (and their respective pokemon, pokemon1) is the winner)
        // if result is inserted as false, trainer2 (and their respective pokemon, pokemon2) is the winner)
        if (battle.getResult() == true) {
            winner = trainers[0].getName();
            // calls method in Battle to increase the level of the winning pokemon,
            // given the increase amount calculated previously
            battle.increaseLevelOfWinner(pokemons[0], increase);
            winnerPokemon = pokemons[0];
        }
        else {
            winner = trainers[1].getName();
            battle.increaseLevelOfWinner(pokemons[1], increase);
            winnerPokemon = pokemons[1];
        }
        // prints winning trainer and pokemon to file, as well as the pokemon's new level
        printWriter.println("   Winner: " + winner + " and " + winnerPokemon.getName() + " with level up to " + winnerPokemon.getLevel());
        printWriter.println("]");

        printWriter.flush();
        printWriter.close();
    }

    @Override
    public String toString() {
        return "Gym{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", trainers=" + trainers +
                ", gymLeader=" + gymLeader +
                '}';
    }
}
