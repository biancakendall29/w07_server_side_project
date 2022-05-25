package com.bnta.pokemon_project.models;

import com.bnta.pokemon_project.repositories.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Battle {

    @Autowired
    PokemonRepository pokemonRepository;

    private Long id;
    private Gym location;
    private LocalDate date;
    //private Trainer trainer1; // trainer1 wins = 1
    //private Trainer trainer2; // trainer2 wine = 0
    private Trainer[] trainersBattling = new Trainer[2];
    private boolean result;

    public Battle(Gym location, LocalDate date, Trainer[] trainersBattling, boolean result) {
        this.location = location;
        this.date = date;
        //this.trainer1 = trainer1;
        //this.trainer2 = trainer2;
        this.trainersBattling = trainersBattling;
        this.result = result;
    }

    public Battle() {}

    public Long getId() {
        return id;
    }

    public Gym getLocation() {
        return location;
    }

    public void setLocation(Gym location) {
        this.location = location;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

//    public Trainer getTrainer1() {
//        return trainer1;
//    }
//
//    public void setTrainer1(Trainer trainer1) {
//        this.trainer1 = trainer1;
//    }
//
//    public Trainer getTrainer2() {
//        return trainer2;
//    }
//
//    public void setTrainer2(Trainer trainer2) {
//        this.trainer2 = trainer2;
//    }


    public Trainer[] getTrainersBattling() {
        return trainersBattling;
    }

    public void setTrainersBattling(Trainer[] trainersBattling) {
        this.trainersBattling = trainersBattling;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Pokemon[] selectPokemons(Trainer[] trainersBattling) {
        // Trainer1
        List<Long> pokemonsTrainer1 = trainersBattling[1].getPokemons().stream()
                .map(pok -> pok.getId())
                .collect(Collectors.toList());
        Random rand = new Random();
        int randomId1 = Math.toIntExact(pokemonsTrainer1.get(rand.nextInt(pokemonsTrainer1.size())));

        // Trainer2
        List<Long> pokemonsTrainer2 = trainersBattling[2].getPokemons().stream()
                .map(pok -> pok.getId())
                .collect(Collectors.toList());
        Random rand2 = new Random();
        int randomId2 = Math.toIntExact(pokemonsTrainer2.get(rand2.nextInt(pokemonsTrainer2.size())));

        Pokemon pok1 = pokemonRepository.findAll()
                .stream()
                .filter(pok -> pok.getId() == randomId1)
                .findAny().get();
        Pokemon pok2 = pokemonRepository.findAll()
                .stream()
                .filter(pok -> pok.getId() == randomId2)
                .findAny().get();

        return new Pokemon[]{pok1, pok2};
    }


    @Override
    public String toString() {
        return "Battle{" +
                "id=" + id +
                ", location=" + location +
                ", date=" + date +
                ", trainersBattling=" + Arrays.toString(trainersBattling) +
                ", result=" + result +
                '}';
    }
}
