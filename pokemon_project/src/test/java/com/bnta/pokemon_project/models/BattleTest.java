package com.bnta.pokemon_project.models;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

public class BattleTest {

    private Trainer trainer1;
    private Trainer trainer2;
    private Battle battle;
    private Gym gym;

    @BeforeEach
    public void setUp(){
        trainer1 = new Trainer("Bianca", LocalDate.of(1999,3,14));
        trainer2 = new Trainer("Amber", LocalDate.of(1999,3,15));
        gym = new Gym("gym name", Arrays.asList(trainer1, trainer2));
        battle = new Battle(gym, LocalDate.of(2022, 5, 25), new Trainer[]{trainer1, trainer2}, true);
    }

    @Test
    public void canGetTrainers() {
        assertThat(battle.getTrainersBattling().length).isEqualTo(2);
    }
}
