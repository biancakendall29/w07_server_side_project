package com.bnta.pokemon_project.models;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.bnta.pokemon_project.repositories.PokemonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Arrays;

public class BattleTest {

    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Trainer trainer1;
    private Trainer trainer2;
    private Battle battle;
    private Gym gym;
    private Trainer[] trainersBattling = new Trainer[2];

    @Autowired
    PokemonRepository pokemonRepository;

    @BeforeEach
    public void setUp(){
        trainer1 = new Trainer("Bianca", LocalDate.of(1999,3,14));
        trainer2 = new Trainer("Amber", LocalDate.of(1999,3,15));
        pokemon1 = new Pokemon("pikachu", Type.ELECTRIC,30, Arrays.asList(trainer1));
        pokemon2 = new Pokemon("pikachu", Type.ELECTRIC,30, Arrays.asList(trainer2));
        trainersBattling = new Trainer[]{trainer1, trainer2};
        gym = new Gym("gym name", Arrays.asList(trainer1, trainer2));
        battle = new Battle(gym, LocalDate.of(2022, 5, 25), trainersBattling, true);
    }

    @Test
    public void canGetTrainers() {
        assertThat(battle.getTrainersBattling().length).isEqualTo(2);
    }

    @Test
    public void canSelectPokemons() {
        Pokemon[] poks = battle.selectPokemons(trainersBattling);
        System.out.println(poks);
        assertThat(poks.length).isEqualTo(2);
    }
}
