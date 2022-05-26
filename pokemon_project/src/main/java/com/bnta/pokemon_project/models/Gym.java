package com.bnta.pokemon_project.models;

import com.bnta.pokemon_project.repositories.TrainerRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "gyms")
public class Gym{

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

    // Battle
    // Call from controller as a request
    public void addBattle(Battle battle, Trainer[] trainers, Pokemon[] pokemons) throws IOException {
        String winner;
        Pokemon winnerPokemon;
        int increase = battle.calculateLevelIncrease(pokemons, battle.getResult());

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

        if (battle.getResult() == true) {
            winner = trainers[0].getName();
            battle.increaseResultOfWinner(pokemons[0], increase);
            winnerPokemon = pokemons[0];
        }
        else {
            winner = trainers[1].getName();
            battle.increaseResultOfWinner(pokemons[1], increase);
            winnerPokemon = pokemons[1];
        }

        printWriter.println("   Winner: " + winner + " and " + winnerPokemon.getName() + " with level up to " + winnerPokemon.getLevel());
        printWriter.println("]");

        printWriter.flush();
        printWriter.close();
    }

//    public Pokemon[] selectPokemons(Trainer[] trainersBattling) {
//        // Trainer1
//        List<Long> pokemonsTrainer1 = trainersBattling[1].getPokemons().stream()
//                .map(pok -> pok.getId())
//                .collect(Collectors.toList());
//        Random rand = new Random();
//        int randomId1 = Math.toIntExact(pokemonsTrainer1.get(rand.nextInt(pokemonsTrainer1.size())));
//
//        // Trainer2
//        List<Long> pokemonsTrainer2 = trainersBattling[2].getPokemons().stream()
//                .map(pok -> pok.getId())
//                .collect(Collectors.toList());
//        Random rand2 = new Random();
//        int randomId2 = Math.toIntExact(pokemonsTrainer2.get(rand2.nextInt(pokemonsTrainer2.size())));
//
//        Pokemon pok1 = trainersBattling[1].getPokemonById((long) randomId1);
//        Pokemon pok2 = pokemonRepository.findAll()
//                .stream()
//                .filter(pok -> pok.getId() == randomId2)
//                .findAny().get();
//
//        return new Pokemon[]{pok1, pok2};
//    }



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
