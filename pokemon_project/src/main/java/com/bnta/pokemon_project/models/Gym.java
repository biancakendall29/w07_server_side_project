package com.bnta.pokemon_project.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    public void addBattle(Battle battle) throws IOException {
        // call select pokemons method
        //Pokemon[] pokemonsBattling = selectPokemons(trainersBattling);

        Long winner;
        if (battle.getResult() == true) {
            winner = battle.getTrainer_ids()[0];
        }
        else {
            winner = battle.getTrainer_ids()[1];
        }

        File file = new File("src//textFiles/battleLog.txt");

        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println("Location: " + battle.getLocation());
        printWriter.println("Date: " + battle.getDate());
        printWriter.println("Trainer 1: " + battle.getTrainer_ids()[0] + " and Trainer 2: " + battle.getTrainer_ids()[1]);
        printWriter.println("Pokemon 1: " + battle.getPokemon_ids()[0] + " and Pokemon 2: " + battle.getPokemon_ids()[1]);
        printWriter.println("Winner: " + winner);

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
