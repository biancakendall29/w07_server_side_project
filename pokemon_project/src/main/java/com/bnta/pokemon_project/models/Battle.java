package com.bnta.pokemon_project.models;

import java.time.LocalDate;
import java.util.Arrays;

public class Battle {

    private String location; // name of a gym
    private LocalDate date;
    private Long[] trainer_ids;
    private Long[] pokemon_ids;
    private boolean result;

    public Battle(String location, LocalDate date, Long[] trainer_ids, Long[] pokemon_ids, boolean result) {
        this.location = location;
        this.date = date;
        this.trainer_ids = trainer_ids;
        this.pokemon_ids = pokemon_ids;
        this.result = result;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long[] getTrainer_ids() {
        return trainer_ids;
    }

    public void setTrainer_ids(Long[] trainer_ids) {
        this.trainer_ids = trainer_ids;
    }

    public Long[] getPokemon_ids() {
        return pokemon_ids;
    }

    public void setPokemon_ids(Long[] pokemon_ids) {
        this.pokemon_ids = pokemon_ids;
    }

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public int calculateLevelIncrease(Pokemon[] pokemons, boolean result) {
        int level1 = pokemons[0].getLevel();
        int level2 = pokemons[1].getLevel();
        int increase;

        // if trainer1/pokemon1 is the winner
        if (result == true) {
            // if pokemon1 had a higher level initially than its opponent, and won, it levels up by
            // a quarter of the difference between their battles
            if (level1 >= level2) {
                increase = (level1 - level2) / 4;
                // if pokemon1 had a lower level initially than its opponent, and won, it levels up by
                // half of the difference between their battles
            } else {
                increase = (level2 - level1) / 2;
            }
        }
        // if trainer2/pokemon2 is the winner
        else {
            // if pokemon2 had a lower level initially than its opponent, and won, it levels up by
            // half of the difference between their battles
            if (level1 >= level2) {
                increase = (level1 - level2) / 2;
                // if pokemon2 had a higher level initially than its opponent, and won, it levels up by
                // a quarter of the difference between their battles
            } else {
                increase = (level2 - level1) / 4;
            }
        }
        // returns the amount for the winning pokemon's level to increase by
        return increase;
    }

    public void increaseLevelOfWinner(Pokemon pokemon, int increase) {
        int original = pokemon.getLevel();
        // increases winning pokemon's level
        pokemon.setLevel(original + increase);
    }

    @Override
    public String toString() {
        return "Battle{" +
                "location='" + location + '\'' +
                ", date=" + date +
                ", trainer_ids=" + Arrays.toString(trainer_ids) +
                ", pokemon_ids=" + Arrays.toString(pokemon_ids) +
                ", result=" + result +
                '}';
    }
}
