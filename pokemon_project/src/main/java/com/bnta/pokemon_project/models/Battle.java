package com.bnta.pokemon_project.models;

import java.time.LocalDate;

public class Battle {

    private Gym location;
    private LocalDate date;
    private Long[] trainer_ids;
    private Long[] pokemon_ids;
    private boolean result;

    public Battle(Gym location, LocalDate date, Long[] trainer_ids, Long[] pokemon_ids, boolean result) {
        this.location = location;
        this.date = date;
        this.trainer_ids = trainer_ids;
        this.pokemon_ids = pokemon_ids;
        this.result = result;
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
}
