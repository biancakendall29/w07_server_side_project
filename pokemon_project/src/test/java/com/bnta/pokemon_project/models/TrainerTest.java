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


}
