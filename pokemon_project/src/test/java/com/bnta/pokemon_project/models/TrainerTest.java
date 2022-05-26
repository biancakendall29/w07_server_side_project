package com.bnta.pokemon_project.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TrainerTest {

    private Trainer trainer;
    private Pokemon pokemon;
    private Gym gym_badge;

    @BeforeEach
    public void setUp(){
        trainer = new Trainer("Bianca", LocalDate.of(1999,3,14));
        pokemon = new Pokemon("pikachu", Type.ELECTRIC,30, Arrays.asList(trainer));
        gym_badge = new Gym("Pure Gym", Arrays.asList(trainer));
    }

    @Test
    public void canAddPokemon(){
        trainer.addPokemon(pokemon);
        assertThat(trainer.getPokemons().size()).isEqualTo(1);
    }

    @Test
    public void canRemovePokemon(){
        trainer.removePokemon(pokemon);
        assertThat(trainer.getPokemons().size()).isEqualTo(0);
    }

    @Test
    public void canAddGym(){
        trainer.addGym(gym_badge);
        assertThat(trainer.getGym_badges().size()).isEqualTo(1);
    }

    @Test
    public void canRemoveGym(){
        trainer.removeGym(gym_badge);
        assertThat(trainer.getGym_badges().size()).isEqualTo(0);
    }


    //
//    private Pokemon pokemon1;
//    private Pokemon pokemon2;
//    private Trainer trainer1;
//    private Trainer trainer2;
//    private Battle battle;
//    private Gym gym;
//    private Trainer[] trainersBattling = new Trainer[2];
//
//    @Autowired
//    PokemonRepository pokemonRepository;
//
//    @BeforeEach
//    public void setUp(){
//        trainer1 = new Trainer("Bianca", LocalDate.of(1999,3,14));
//        trainer2 = new Trainer("Amber", LocalDate.of(1999,3,15));
//        pokemon1 = new Pokemon("pikachu", Type.ELECTRIC,30, Arrays.asList(trainer1));
//        pokemon2 = new Pokemon("pikachu", Type.ELECTRIC,30, Arrays.asList(trainer2));
//        trainersBattling = new Trainer[]{trainer1, trainer2};
//        gym = new Gym("gym name", Arrays.asList(trainer1, trainer2));
//        battle = new Battle(gym, LocalDate.of(2022, 5, 25), trainersBattling, true);
//    }

//    @Test
//    public void canGetTrainers() {
//        assertThat(battle.getTrainersBattling().length).isEqualTo(2);
//    }
//
//    @Test
//    public void canSelectPokemons() {
//        Pokemon[] poks = battle.selectPokemons(trainersBattling);
//        System.out.println(poks);
//        assertThat(poks.length).isEqualTo(2);
//    }


}
